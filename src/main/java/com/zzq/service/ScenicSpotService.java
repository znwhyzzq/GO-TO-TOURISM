package com.zzq.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.IService;
import com.zzq.entity.ScenicSpot;
import com.zzq.exception.GlobalExceptionHandler;
import com.zzq.exception.GlobalExceptionMyHandler;
import com.zzq.qo.ScenciSpotQuery;
import com.zzq.vo.AnalysisVO;
import com.zzq.vo.SpotVo;

import java.util.List;


public interface ScenicSpotService extends IService<ScenicSpot> {

    Integer count0();

    Integer count1();

    Boolean saveOrUpdateScenicSpot(ScenicSpot scenicSpot) throws GlobalExceptionHandler;

    ScenicSpot findScenicSpotById(Long id) throws GlobalExceptionMyHandler;

    Boolean deleteById(Long id) throws GlobalExceptionHandler;

    Boolean updateStates(ScenicSpot scenicSpot) throws GlobalExceptionHandler;

    List<AnalysisVO> stateAll() throws GlobalExceptionHandler;

    List<ScenicSpot> findAll() throws GlobalExceptionHandler;

    IPage<ScenicSpot> listPage(ScenciSpotQuery query) throws GlobalExceptionHandler;

    List<SpotVo> getSpotHotel() throws GlobalExceptionHandler;


}
