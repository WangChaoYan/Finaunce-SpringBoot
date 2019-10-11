package com.qf.controller;

import com.qf.domain.Order;
import com.qf.service.OrderService;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @Author 杨小柒丶
 * @Date 2019/10/11
 * @Time 15:38
 */
@RestController
public class OrderController {
    @Autowired
    private OrderService orderService;
    @RequestMapping("/orderFindAll")
    public List<Order> selectAll(){
        return orderService.findAll();
    }
    @RequestMapping("/findByIdOrder")
    public Order findByIdOrder(@RequestBody Order order ){

        return orderService.findById(order.getOrid());
    }
    @RequestMapping("/updateOrder")
    public Order updateOrder(@RequestBody Order order){
        return orderService.updateOrder(order);
    }
}
