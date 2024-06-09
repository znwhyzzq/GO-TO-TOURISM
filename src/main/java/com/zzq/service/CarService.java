package com.zzq.service;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.IService;
import com.zzq.comon.ResponseResult;
import com.zzq.entity.Car;
import com.zzq.qo.CarQuery;
import com.zzq.vo.AnalysisVO;

import java.util.List;


public interface CarService extends IService<Car> {

    Integer count1() throws Exception;

    ResponseResult saveOrUpdateCar(Car car);

    ResponseResult findCarById(Long id);

    void deleteById(Long id) throws Exception;

    Boolean updateStates(Car car) throws Exception;

    List<AnalysisVO> typeAll() throws Exception;

    List<AnalysisVO> stateAll() throws Exception;

    Page<Car> listPage(CarQuery query) throws Exception;
}
