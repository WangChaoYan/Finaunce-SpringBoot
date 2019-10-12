package com.qf.controller;

import com.qf.config.AlipayNotifyParam;
import org.slf4j.Logger;
import com.alipay.api.AlipayApiException;
import com.qf.dao.OrderRepository;
import com.qf.domain.Order;
import com.qf.domain.Product;
import com.qf.domain.User;
import com.qf.service.UserService;
import com.qf.utils.AlipayUtils;
import org.apache.shiro.SecurityUtils;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.apache.shiro.subject.Subject;

import javax.annotation.Resource;
import java.util.Date;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

@RestController
public class AlipayController{
@Autowired
    private AlipayUtils alipayUtils;
@Resource
    private OrderRepository orderRepository;
@Autowired
    private UserService userService;
    @RequestMapping(value = "/pay",method = RequestMethod.POST)
    public String pay(@RequestBody Product product){
        String pay="";
        try{
            pay=alipayUtils.pay(product.getLimits(),product.getPname());
        } catch (AlipayApiException e) {
            e.printStackTrace();
        }
        Order order=new Order();
        Subject subject= SecurityUtils.getSubject();
        String principal=(String)subject.getPrincipal();
        User user=userService.findUser(principal);
        String tradeno=alipayUtils.trade_no;
        order.setUid(user.getUid());
        order.setTradacount(Float.valueOf(product.getLimits()));
        order.setTradcname(product.getPname());
        order.setTradstatus("未支付");
        order.setTradnum(tradeno);
        System.out.println(tradeno+"++++");
        order.setTradtime(new Date());
        System.out.println(order);
        Order save=orderRepository.save(order);

        if ((save!=null)){
            System.out.println("生成一条订单信息");
        }
        return  pay;
    }
    private static Logger logger = LoggerFactory.getLogger(AlipayController.class);
        private ExecutorService executorService=Executors.newFixedThreadPool(20);
    @RequestMapping(value = "/alipay_callback",method = RequestMethod.POST)
    public List<Order> alipayCallBack(@RequestBody AlipayNotifyParam alipayNotifyParam ){
        String tradnum=alipayNotifyParam.getOut_trade_no();
        System.out.println(tradnum);
        Order order = orderRepository.findByTradnum(tradnum);
        if(order!=null){
            order.setTradstatus("支付完成");
        }
        orderRepository.saveAndFlush(order);
        List<Order> list = orderRepository.findAllByUid(1);
        return list;
    }

}