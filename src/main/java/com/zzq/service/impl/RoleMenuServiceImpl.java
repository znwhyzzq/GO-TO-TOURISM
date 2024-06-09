package com.zzq.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.zzq.entity.RoleMenu;
import com.zzq.mapper.RoleMenuMapper;
import com.zzq.service.RoleMenuService;
import org.springframework.stereotype.Service;


@Service
public class RoleMenuServiceImpl extends ServiceImpl<RoleMenuMapper, RoleMenu> implements RoleMenuService {
}
