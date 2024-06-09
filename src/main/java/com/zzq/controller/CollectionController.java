package com.zzq.controller;


import com.zzq.comon.ResponseResult;
import com.zzq.entity.Collection;
import com.zzq.qo.CollectQuery;
import com.zzq.service.CollectionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/collection")
//@PreAuthorize("hasRole('Admin')")
public class CollectionController {
    @Autowired
    private CollectionService collectionService;

    /**
     * 显示用户所有收藏
     *
     * @param query
     * @return
     */
    @PostMapping("/findCollectionByPage")
    public ResponseResult findCollectionByPage(@RequestBody CollectQuery query) {
        return collectionService.findCollectionByPage(query);

    }

    @PostMapping("/Collection")
    public ResponseResult findCollection(@RequestBody CollectQuery query) {
        return collectionService.findSimilarCollectionsByPage(query);
    }

    @GetMapping("/findCollection")
    public ResponseResult findCollectionByPage() {
        return collectionService.findCollection();

    }

    /**
     * 新增收藏
     *
     * @param collection
     * @return
     */
    @PostMapping("/save")
    public ResponseResult saveCollection(@RequestBody Collection collection) {

        return collectionService.saveCollection(collection);
    }

    /**
     * 判断用户是否收藏
     *
     * @param productId
     * @param productType
     * @return
     */
    //收藏按钮回显
    @GetMapping("/isCollection")
    public ResponseResult isCollection(Long productId, Long productType) {
        //2.已登录,判断是否收藏
        Integer count= collectionService.isCollection(productId, productType);
        if (count == 0) {
            return new ResponseResult(400, "用户没有收藏", false);
        }
        return new ResponseResult(200, "用户已经收藏", true);
    }
}
