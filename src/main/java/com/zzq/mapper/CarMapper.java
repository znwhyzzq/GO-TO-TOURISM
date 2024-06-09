package com.zzq.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.zzq.entity.Car;
import org.apache.ibatis.annotations.Update;


public interface CarMapper extends BaseMapper<Car> {
    @Update("UPDATE tb_car SET state=#{state} WHERE DELETE_STATUS=0 AND ID =#{id} ")
    public boolean updateState(Car car);
}
