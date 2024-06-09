package com.zzq.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.IService;
import com.zzq.comon.ResponseResult;
import com.zzq.entity.Strategy;
import com.zzq.exception.GlobalExceptionHandler;
import com.zzq.qo.StrategyQuery;

import java.util.List;
import java.util.Map;


public interface StrategyService extends IService<Strategy> {


    ResponseResult likeStrategy(Long id) throws GlobalExceptionHandler;

    Boolean saveOrUpdateStrategy(Strategy strategy) throws GlobalExceptionHandler;

    Strategy findStrategyById(Long id) throws GlobalExceptionHandler;

    Boolean deleteById(Long id) throws GlobalExceptionHandler;

    Boolean updateStates(Strategy strategy) throws GlobalExceptionHandler;


    List<Map<String, Object>> stateAll() throws GlobalExceptionHandler;

    List<Strategy> findAllUser() throws GlobalExceptionHandler;

    IPage<Strategy> listPage(StrategyQuery query) throws GlobalExceptionHandler;


    ResponseResult collectStrategy(Long id) throws GlobalExceptionHandler;

    IPage<Strategy> listMyStrategy(StrategyQuery query) throws GlobalExceptionHandler;

    ResponseResult getProduct(Integer productType) throws GlobalExceptionHandler;

    List<Strategy> listRanking() throws GlobalExceptionHandler;
}
