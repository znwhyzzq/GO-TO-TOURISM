package com.zzq.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.zzq.DTO.OrderDTO;
import com.zzq.entity.Order;
import com.zzq.exception.GlobalExceptionHandler;
import com.zzq.exception.GlobalExceptionMyHandler;
import com.zzq.qo.OrderQuery;
import com.zzq.qo.UserOrderQuery;
import com.zzq.vo.AnalysisVO;
import com.zzq.vo.OrderListV0;

import java.util.List;


public interface OrderService extends IService<Order> {

    Integer count0() throws GlobalExceptionHandler;

    Integer count1() throws GlobalExceptionHandler;

    Boolean updateOrder(Order order) throws GlobalExceptionMyHandler;

    Order findOrderById(Long id) throws GlobalExceptionMyHandler;

    Boolean deleteById(Long id) throws GlobalExceptionHandler;

    Boolean updateStates(Order order) throws GlobalExceptionHandler;

    List<AnalysisVO> typeAll() throws GlobalExceptionHandler;

    List<AnalysisVO> stateAll() throws GlobalExceptionHandler;

    List<Order> findAll() throws GlobalExceptionHandler;

    OrderListV0 listPage(OrderQuery query) throws GlobalExceptionHandler;

    Long userOrder(OrderDTO orderDto) throws GlobalExceptionHandler;

    Boolean toBePaid(Order order) throws GlobalExceptionMyHandler;


    OrderListV0 orderListPage(UserOrderQuery query) throws GlobalExceptionHandler;

    Boolean callOff(Order order) throws GlobalExceptionHandler;

    /**
     * 退款
     *
     * @param order
     * @return
     * @throws GlobalExceptionHandler
     */
    Boolean refunded(Order order) throws GlobalExceptionHandler;

    Boolean deleteByUser(Long id) throws GlobalExceptionHandler;

    List<AnalysisVO> attractions();

    List<AnalysisVO> getOrderPayedTotal();
}
