package com.zzq.service;


import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.IService;
import com.zzq.entity.Insurance;
import com.zzq.exception.GlobalExceptionHandler;
import com.zzq.qo.InsuranceQuery;
import com.zzq.vo.AnalysisVO;

import java.util.List;


public interface InsuranceService extends IService<Insurance> {

    Integer count0() throws GlobalExceptionHandler;

    Integer count1() throws GlobalExceptionHandler;

    Boolean saveOrUpdateInsurance(Insurance insurance) throws GlobalExceptionHandler;

    Insurance findInsuranceById(Long id) throws GlobalExceptionHandler;

    Boolean deleteById(Long id) throws GlobalExceptionHandler;

    Boolean updateStates(Insurance insurance) throws GlobalExceptionHandler;

    List<AnalysisVO> typeAll() throws GlobalExceptionHandler;

    List<AnalysisVO> stateAll() throws GlobalExceptionHandler;

    List<Insurance> findAll() throws GlobalExceptionHandler;

    IPage<Insurance> listPage(InsuranceQuery query) throws GlobalExceptionHandler;


    List<AnalysisVO> InsuranceCompanyAll() throws GlobalExceptionHandler;
}
