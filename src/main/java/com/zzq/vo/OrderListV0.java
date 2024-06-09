package com.zzq.vo;

import com.zzq.entity.Order;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;


@Data
@AllArgsConstructor
@NoArgsConstructor
public class OrderListV0 {
    Double orderSum;
    List<Order> orderList;
    private Long total;
}
