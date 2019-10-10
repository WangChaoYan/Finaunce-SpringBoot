package com.qf.controller;

import com.alipay.api.AlipayApiException;
import com.qf.domain.Product;
import com.qf.utils.AlipayUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


/**
 * @Author
 * @Date 2019/10/9
 * @Time 19:51
 */
@RestController
public class PayController {

    @Autowired
    private AlipayUtils alipayUtils;

    @RequestMapping(value = "/pay",method = RequestMethod.POST)
    public String pay(@RequestBody Product product){
        String pay="";
        try {
            pay = alipayUtils.pay(product.getLimits(),product.getPname());
        } catch (AlipayApiException e) {
            e.printStackTrace();
        }
        System.out.println(pay);
        return pay;
    }

}
