package com.zzq.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.zzq.entity.Notic;

import java.util.List;


public interface NoticService extends IService<Notic> {

    Notic getByNoticById(Long id) throws Exception;

    void saveOrUpdateNotic(Notic notic) throws Exception;

    void delete(Long id) throws Exception;

    void updateStates(Notic notic) throws Exception;

    List<Notic> getByNoticAll() throws Exception;

    List<Notic> getByNoticList() throws Exception;
}
