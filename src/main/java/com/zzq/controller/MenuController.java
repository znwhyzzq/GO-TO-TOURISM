package com.zzq.controller;

import com.zzq.comon.ResponseResult;
import com.zzq.service.MenuService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("menu")
public class MenuController {
    private final static Logger logger = LoggerFactory.getLogger(MenuController.class);
    @Autowired
    private MenuService menuService;


    @GetMapping("list")
    public ResponseResult getList(Long roleId) {
        try {
            return ResponseResult.success(menuService.selectList(roleId));
        } catch (Exception e) {
            logger.error("获取权限树结构失败={}", e.getMessage());
            return ResponseResult.fail(e.getMessage());
        }
    }


}
