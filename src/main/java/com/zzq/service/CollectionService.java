package com.zzq.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.zzq.comon.ResponseResult;
import com.zzq.entity.Collection;
import com.zzq.qo.CollectQuery;


public interface CollectionService extends IService<Collection> {

    ResponseResult saveCollection(Collection collection);

    ResponseResult findCollectionByPage(CollectQuery query);

    Integer isCollection(Long productId, Long productType);

    ResponseResult findCollection();

    ResponseResult findSimilarCollectionsByPage(CollectQuery query);
}
