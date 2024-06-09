package com.zzq.vo;

import lombok.Data;

import java.io.Serializable;
import java.util.List;

@Data
public class OrderIdsVo implements Serializable {
    private List<Long> orderIds;
}
