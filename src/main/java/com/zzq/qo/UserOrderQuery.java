package com.zzq.qo;

import lombok.Data;

@Data
public class UserOrderQuery extends Query {
    private Integer state;
    private Integer productType;
}
