package com.zzq.controller;

import com.zzq.comon.ResponseResult;
import com.zzq.entity.Admin;
import com.zzq.service.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class LoginController {

    @Autowired
    private LoginService loginSercice;

    @PostMapping("/admin/login")
    public ResponseResult login(@RequestBody Admin admin) {
        return loginSercice.login(admin);
    }

    @GetMapping("/loginOut")
    public ResponseResult logout() {
        return loginSercice.logout();
    }


}
