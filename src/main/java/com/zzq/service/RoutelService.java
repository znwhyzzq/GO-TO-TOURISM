package com.zzq.service;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.IService;
import com.zzq.entity.Routel;
import com.zzq.exception.GlobalExceptionHandler;
import com.zzq.exception.GlobalExceptionMyHandler;
import com.zzq.qo.RouteQuery;
import com.zzq.vo.AnalysisVO;

import java.util.List;


public interface RoutelService extends IService<Routel> {

    Integer count0();

    Integer count1();

    Boolean saveOrUpdateRoutel(Routel routel) throws GlobalExceptionHandler;

    Routel findRoutelById(Long id) throws GlobalExceptionMyHandler;

    Boolean deleteById(Long id) throws GlobalExceptionHandler;

    Boolean updateStates(Routel routel) throws GlobalExceptionHandler;

    List<AnalysisVO> stateAll() throws GlobalExceptionHandler;

    Page<Routel> listPage(RouteQuery query) throws GlobalExceptionHandler;
}
