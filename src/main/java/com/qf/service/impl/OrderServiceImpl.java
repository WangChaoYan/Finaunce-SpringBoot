package com.qf.service.impl;

import com.qf.dao.OrderRepository;
import com.qf.domain.Order;
import com.qf.service.OrderService;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Author 杨小柒丶
 * @Date 2019/10/11
 * @Time 15:27
 */
@Service("orderServiceImpl")
public class OrderServiceImpl implements OrderService {
    @Autowired
    private OrderRepository orderRepository;
    @Override
    public List<Order> findAll() {
        return orderRepository.findAll();
    }

    @Override
    public Order updateOrder(@Param("order") Order order)
    {
        return orderRepository.saveAndFlush(order);
    }

    @Override
    public Order findById(Integer orid) {
        return orderRepository.findById(orid).get();
    }

//    @Override
//    public Order selectById(Integer orid) {
//        return orderRepository.findAllById(orid);
//    }


}
