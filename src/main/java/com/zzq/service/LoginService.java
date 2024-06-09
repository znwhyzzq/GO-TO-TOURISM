package com.zzq.service;

import com.zzq.comon.ResponseResult;
import com.zzq.entity.Admin;

public interface LoginService {

    ResponseResult login(Admin admin);

    ResponseResult logout();

}
