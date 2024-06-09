package com.zzq.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.zzq.entity.Menu;

import java.util.List;

public interface MenuMapper extends BaseMapper<Menu> {
    /**
     * 查看用户拥有的权限
     *
     * @param userid
     * @return
     */
    List<String> selectPermsByUserId(Long userid);
}
