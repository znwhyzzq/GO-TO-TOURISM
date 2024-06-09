package com.zzq.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.zzq.entity.Menu;
import com.zzq.vo.MenuListVo;


public interface MenuService extends IService<Menu> {
    MenuListVo selectList(Long roleId) throws Exception;

}
