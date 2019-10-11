package com.qf.service;

import com.qf.domain.Order;

import java.util.List;

/**
 * @Author 杨小柒丶
 * @Date 2019/10/11
 * @Time 15:19
 */
public interface OrderService {
    /*
    查询所有订单
     */
    List<Order> findAll();
    /*
    修改订单
     */
    Order updateOrder(Order order);
    /*
    根据ID查找
     */
//    Order selectById(Integer orid);
    Order findById(Integer orid);
}
