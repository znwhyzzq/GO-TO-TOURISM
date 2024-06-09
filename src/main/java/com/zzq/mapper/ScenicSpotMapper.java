package com.zzq.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.zzq.entity.ScenicSpot;
import com.zzq.vo.SpotVo;
import org.apache.ibatis.annotations.Select;

import java.util.List;


public interface ScenicSpotMapper extends BaseMapper<ScenicSpot> {

    @Select("SELECT `scenic_spot`.`ID` spotId,`scenic_spot`.`SPOT_NAME` spotName FROM `scenic_spot`")
    List<SpotVo> getSpotHotel();
}
