package com.zzq.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.zzq.entity.UserRole;
import com.zzq.mapper.UserRoleMapper;
import com.zzq.service.UserRoleService;
import org.springframework.stereotype.Service;


@Service
public class UserRoleServiceImpl extends ServiceImpl<UserRoleMapper, UserRole> implements UserRoleService {
}
