package com.zzq.controller;


import com.baomidou.mybatisplus.core.metadata.IPage;
import com.zzq.comon.ResponseResult;
import com.zzq.entity.ScenicSpot;
import com.zzq.exception.GlobalExceptionHandler;
import com.zzq.qo.ScenciSpotQuery;
import com.zzq.service.ScenicSpotService;
import com.zzq.vo.SpotVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.util.CollectionUtils;
import org.springframework.util.ObjectUtils;
import org.springframework.web.bind.annotation.*;

import java.util.Collections;
import java.util.List;


@RestController
@RequestMapping("/scenic")
//@PreAuthorize("hasRole('Admin')")
public class ScenicSpotController {

    @Autowired
    private ScenicSpotService scenicSpotService;

    @GetMapping("/count0")
    @PreAuthorize("hasAuthority('system:scenicSpot:count')")
    public ResponseResult count0() {
        return ResponseResult.success(scenicSpotService.count0());
    }


    @GetMapping("/count1")
    @PreAuthorize("hasAuthority('system:scenicSpot:count1')")
    public ResponseResult count1() {
        return ResponseResult.success(scenicSpotService.count1());
    }



    @PostMapping("/saveOrUpdateScenicSpot")
    @PreAuthorize("hasAuthority('system:scenicSpot:saveOrUpdateScenicSpot')")
    public ResponseResult saveOrUpdateScenicSpot(@RequestBody ScenicSpot scenicSpot) throws GlobalExceptionHandler {
        if (ObjectUtils.isEmpty(scenicSpot)) {
            return ResponseResult.fail("scenicSpot不能为null");
        }
        Boolean isSuccess = scenicSpotService.saveOrUpdateScenicSpot(scenicSpot);
        return ResponseResult.isSuccess(isSuccess, ObjectUtils.isEmpty(scenicSpot.getId()) ? "新增" : "修改");


    }


    @GetMapping("/deleteById")
    @PreAuthorize("hasAuthority('system:scenicSpot:deleteById')")
    public ResponseResult deleteById(Long id) throws GlobalExceptionHandler {
        return ResponseResult.isSuccess(scenicSpotService.deleteById(id), "删除");
    }


    @PostMapping("/listPage")
    public ResponseResult listPage(@RequestBody ScenciSpotQuery query) throws GlobalExceptionHandler {
        IPage<ScenicSpot> result = scenicSpotService.listPage(query);
        if (CollectionUtils.isEmpty(result.getRecords())) {
            return ResponseResult.success(Collections.emptyList());
        }
        return ResponseResult.success(result.getRecords(), result.getTotal());

    }


    @GetMapping("/findById")
    public ResponseResult findScenicSpotById(@RequestParam Long id) throws GlobalExceptionHandler {
        if (ObjectUtils.isEmpty(id)) {
            return ResponseResult.fail("id不能为null");
        }
        ScenicSpot spot = scenicSpotService.findScenicSpotById(id);
        return ResponseResult.success(spot);

    }



    @PostMapping("/updateStates")
    @PreAuthorize("hasAuthority('system:scenicSpot:updateStates')")
    public ResponseResult updateStates(@RequestBody ScenicSpot scenicSpot) throws GlobalExceptionHandler {
        if (ObjectUtils.isEmpty(scenicSpot)) {
            return ResponseResult.fail("scenicSpot不能为null");
        }
        return ResponseResult.isSuccess(scenicSpotService.updateStates(scenicSpot), "修改状态");
    }



    @GetMapping("/stateAll")
    @PreAuthorize("hasAuthority('system:scenicSpot:stateAll')")
    public ResponseResult stateAll() throws GlobalExceptionHandler {
        return ResponseResult.success(scenicSpotService.stateAll());

    }


    @GetMapping("/findAll")
    public ResponseResult findAll() throws GlobalExceptionHandler {
        return ResponseResult.success(scenicSpotService.findAll());

    }


    @GetMapping("/getSpotHotel")
    public List<SpotVo> getSpotHotel() throws GlobalExceptionHandler {
        return scenicSpotService.getSpotHotel();
    }

}
