package com.zzq.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.zzq.entity.Strategy;
import org.apache.ibatis.annotations.Select;

import java.util.List;


public interface StrategyMapper extends BaseMapper<Strategy> {

    @Select(" SELECT ID,ADD_USER_ID,ADD_TIME,DELETE_STATUS,MODIFY_TIME,IMG_URL,TITLE,RATING,SUMMARY,INTRO_URL,STATE,liked,comments,collects,product_type " +
            " FROM strategy " +
            " WHERE DELETE_STATUS=0  AND STATE=1 ORDER BY liked DESC LIMIT 0,5")
    List<Strategy> getListByLiked();

}
