package com.zzq.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.zzq.entity.Admin;
import com.zzq.entity.Province;
import com.zzq.vo.ProvinceVo;

import java.util.List;

public interface AdminMapper extends BaseMapper<Admin> {

    public List<ProvinceVo> findProvinceByid();

    public List<Province> findfindProvinceAll();

    public boolean state(long id);

}
