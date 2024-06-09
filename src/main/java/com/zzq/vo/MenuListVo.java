package com.zzq.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;


@NoArgsConstructor
@AllArgsConstructor
@Data
public class MenuListVo {
    private List<MenuListTreeVo> menuList;
    private List<Long> checkList;
    private List<Long> backList;
}
