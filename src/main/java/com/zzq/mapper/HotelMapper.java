package com.zzq.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.zzq.entity.Hotel;
import com.zzq.vo.HotelVo;
import org.apache.ibatis.annotations.Select;

import java.util.List;


public interface HotelMapper extends BaseMapper<Hotel> {

    @Select("SELECT `tb_hotel`.`ID` hotelId,`tb_hotel`.`HOTEL_NAME` hotelName FROM `tb_hotel` ")
    public List<HotelVo> getHotelSpot();

}
