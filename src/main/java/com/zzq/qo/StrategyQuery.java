package com.zzq.qo;

import lombok.Data;


@Data
public class StrategyQuery extends Query {
    private String title;
    private Integer addUserId;
    private Long productType;


}
