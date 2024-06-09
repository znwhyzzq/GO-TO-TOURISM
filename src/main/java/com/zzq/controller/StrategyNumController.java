package com.zzq.controller;

import com.zzq.comon.ResponseResult;
import com.zzq.entity.StrategyNum;
import com.zzq.service.StrategyNumService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("strategyNum")
//@PreAuthorize("hasRole('Admin')")
public class StrategyNumController {
    @Autowired
    private StrategyNumService strategyNumService;

    @GetMapping("/getStrategyNumById")
    public ResponseResult getStrategyNumById(Long id) {
        StrategyNum strategyNum = strategyNumService.getById(id);
        return ResponseResult.success(strategyNum);
    }


}
