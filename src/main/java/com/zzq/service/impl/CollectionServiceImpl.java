package com.zzq.service.impl;

import cn.hutool.core.util.BooleanUtil;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.zzq.comon.ResponseResult;
import com.zzq.entity.Collection;
import com.zzq.mapper.CollectionMapper;
import com.zzq.qo.CollectQuery;
import com.zzq.service.CollectionService;
import com.zzq.service.UserRecommendationService;
import com.zzq.utils.WebUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.*;
import java.util.stream.Collectors;

import static com.zzq.constant.RedisConstants.CACHE_COLLECT_KEY;


@Service
public class CollectionServiceImpl extends ServiceImpl<CollectionMapper, Collection> implements CollectionService {
    @Resource
    private CollectionMapper collectionMapper;

    @Resource
    private UserRecommendationService userRecommendationService;
    @Autowired
    private RedisTemplate<String, String> redisTemplate;

    /**
     * 添加收藏
     *
     * @param collection
     * @return
     */
    @Override
    public ResponseResult saveCollection(Collection collection) {
        Long userId = WebUtils.getUserId();
        Date date = new Date();
        Long productId = collection.getProductId();
        Integer productType = collection.getProductType();
        //2.判断当前登录用户是否已经收藏
        String key = CACHE_COLLECT_KEY + userId + ":" + productId;
        Boolean member = redisTemplate.opsForSet().isMember(key, userId.toString());
        if (BooleanUtil.isFalse(member)) {
            //3.如果未收藏，可以收藏
            //3.1数据库收藏数+1
            // boolean isSuccess = update().setSql("collects=collects+1").eq("id", collection.getId()).update();
            //3.2保存用户到Redis的set集合
            collection.setUserId(userId);
            collection.setAddTime(date);
            boolean save = save(collection);
            if (save) {
                redisTemplate.opsForSet().add(key, userId.toString());
                return new ResponseResult(200, "收藏成功", true);
            }
            return new ResponseResult(400, "收藏失败！！");
        } else {
            //4.如果已收藏 取消收藏
            //4.2把用户从Redis的set集合移除
            redisTemplate.opsForSet().remove(key, userId.toString());

            boolean remove = remove(new LambdaQueryWrapper<Collection>()
                    .eq(Collection::getProductId, productId)
                    .eq(Collection::getProductType, productType));
            if (!remove) {
                return new ResponseResult(400, "取消收藏失败");
            }
        }
        return new ResponseResult(200, "取消收藏成功", false);
    }


    @Override
    public ResponseResult findCollectionByPage(CollectQuery query) {
        Long userId = WebUtils.getUserId();
        //分页
        Page<Collection> page = new Page<>();
        page.setCurrent(query.getCurrentPage());
        page.setSize(query.getPageSize());
        //条件查询
        LambdaQueryWrapper<Collection> lambdaQueryWrapper = new LambdaQueryWrapper<>();
        lambdaQueryWrapper.eq(userId != null, Collection::getUserId, userId);
        lambdaQueryWrapper.eq(query.getProductType() != null, Collection::getProductType, query.getProductType());

        Page<Collection> result = collectionMapper.selectPage(page, lambdaQueryWrapper);
        if (result == null || result.getRecords().isEmpty()) {
            return ResponseResult.success(Collections.emptyList());
        }
        System.out.println(result);
        long total = result.getTotal();
        List<Collection> records = result.getRecords();
        return ResponseResult.success(records, total);

    }

    @Override
    public Integer isCollection(Long productId, Long productType) {
        Long userId = WebUtils.getUserId();
        // 查询数据库判断是否收藏
        Integer count = query().eq("Product_Id", productId).eq("Product_Type", productType)
                .eq("USER_ID", userId).count();
        return count;
    }

    @Override
    public ResponseResult findCollection() {
        QueryWrapper<Collection> queryWrapper1 = new QueryWrapper<>();
        queryWrapper1.select("COUNT(*) as total_collections", "Product_Id", "Product_Type")
                .ne("Product_Type", 5)
                .groupBy("Product_Id", "Product_Type")
                .orderByDesc("total_collections")
                .last("LIMIT 5");
        List<Map<String, Object>> topCollections = this.listMaps(queryWrapper1);
        List<Map<String, Object>> finalResults = new ArrayList<>();
        for (Map<String, Object> topCollection : topCollections) {
            QueryWrapper<Collection> queryWrapper2 = new QueryWrapper<>();
            queryWrapper2.select("title", "Product_Type", "Product_Id", "id")
                    .eq("Product_Type", topCollection.get("Product_Type"))
                    .eq("Product_Id", topCollection.get("Product_Id"));
            Map<String, Object> titleResult = this.getMap(queryWrapper2);
            topCollection.putAll(titleResult);
            finalResults.add(topCollection);
        }
        return ResponseResult.success(finalResults);

    }

    @Override
    public ResponseResult findSimilarCollectionsByPage(CollectQuery query) {
        Long userId = WebUtils.getUserId();
        List<Long> similarUserIds = userRecommendationService.getSimilarUserIds(userId);
        if (similarUserIds.isEmpty()) {
            return ResponseResult.fail();
        }
        // 构建查询条件，包括相似用户的收藏
        LambdaQueryWrapper<Collection> lambdaQueryWrapper = new LambdaQueryWrapper<>();
        lambdaQueryWrapper.in(Collection::getUserId, similarUserIds);
        lambdaQueryWrapper.eq(query.getProductType() != null, Collection::getProductType, query.getProductType());
        lambdaQueryWrapper.ne(Collection::getProductType, 5);
        List<Collection> result = collectionMapper.selectList(lambdaQueryWrapper);
        if (result == null || result.isEmpty()) {
            return ResponseResult.success(Collections.emptyList());
        }
        // 排除当前用户已经收藏的项目
        List<Collection> filteredRecords = result.stream()
                .filter(collection -> isCollection(collection.getProductId(),
                        Long.valueOf(collection.getProductType())).equals(0)).limit(5)
                .collect(Collectors.toList());
        return ResponseResult.success(filteredRecords);
    }

}
