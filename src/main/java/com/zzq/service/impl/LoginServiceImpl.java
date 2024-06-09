package com.zzq.service.impl;

import com.zzq.comon.RedisCache;
import com.zzq.comon.ResponseResult;
import com.zzq.entity.Admin;
import com.zzq.entity.LoginUser;
import com.zzq.mapper.AdminMapper;
import com.zzq.service.LoginService;
import com.zzq.utils.JwtUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.Objects;

@Service
public class LoginServiceImpl implements LoginService {
    @Autowired
    private AuthenticationManager authenticationManager;
    @Autowired
    private RedisCache redisCache;
    @Resource
    private AdminMapper adminMapper;

    @Override
    public ResponseResult login(Admin admin) {
        //Authentication.Manager authenticate,进行用户认证
        UsernamePasswordAuthenticationToken authenticationToken = new UsernamePasswordAuthenticationToken(admin.getUsername(), admin.getPassword());
        Authentication authenticate = authenticationManager.authenticate(authenticationToken);
        //如果认证没通过，使用对应的提示
        if (Objects.isNull(authenticate)) {
            throw new RuntimeException("登录失败");
        }
        //如果认证通过，使用userid生成jwt jwt存入responseResult返回
        LoginUser loginUser = (LoginUser) authenticate.getPrincipal();
        Long userid = loginUser.getAdmin().getId();
        if (!adminMapper.state(userid)) {
            throw new RuntimeException("登录失败");
        }
        String jwt = JwtUtil.createJWT(userid.toString());
        HashMap<String, Object> map = new HashMap<>();
        map.put("token", jwt);
        if (loginUser.getAdmin().getUserType() == 2) {
            map.put("adminid", loginUser.getAdmin().getId());
        }
        if (loginUser.getAdmin().getUserType() == 1 || loginUser.getAdmin().getUserType() == 0) {
            map.put("adminid", loginUser.getAdmin().getId());
        }
        //把完整的用户信息存入redis userid作为key
        redisCache.setCacheObject("login:" + userid.toString(), loginUser);
        return new ResponseResult(200, "登陆成功", map);
    }

    @Override
    public ResponseResult logout() {
        //获取SecorityContextHolder中的id
        UsernamePasswordAuthenticationToken authentication = (UsernamePasswordAuthenticationToken) SecurityContextHolder.getContext().getAuthentication();
        LoginUser loginUser = (LoginUser) authentication.getPrincipal();
        Long userid = loginUser.getAdmin().getId();
        //删除redis中的值
        String redKey = "login:" + userid;
        redisCache.deleteObject(redKey);
        return new ResponseResult(200, "注销成功");
    }
}
