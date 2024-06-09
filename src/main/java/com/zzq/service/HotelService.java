package com.zzq.service;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.IService;
import com.zzq.entity.Hotel;
import com.zzq.entity.ScenicSpot;
import com.zzq.exception.GlobalExceptionHandler;
import com.zzq.qo.HotelQuery;
import com.zzq.vo.AnalysisVO;
import com.zzq.vo.HotelVo;

import java.util.List;


public interface HotelService extends IService<Hotel> {

    Integer count0() throws GlobalExceptionHandler;

    Integer count1() throws Exception;

    void saveOrUpdateHotel(Hotel hotel) throws Exception;

    Hotel findHotelById(Long id) throws Exception;

    void deleteById(Long id) throws GlobalExceptionHandler;

    Boolean updateStates(Hotel hotel) throws Exception;

    List<AnalysisVO> typeAll() throws GlobalExceptionHandler;

    List<AnalysisVO> stateAll() throws GlobalExceptionHandler;

    Page<Hotel> listPage(HotelQuery query) throws GlobalExceptionHandler;

    List<Hotel> listHotelSpot(Long scenicSpotId) throws GlobalExceptionHandler;

    List<ScenicSpot> listSpotHotel(Long scenicSpotId) throws GlobalExceptionHandler;

    List<HotelVo> getHotelSpot();
//    ResponseResult listPage(QueryPageParam query);

}
