package com.qf.controller;

import com.qf.dao.UserRepository;
import com.qf.domain.DingDan;
import com.qf.domain.Order;
import com.qf.domain.Product;
import com.qf.domain.User;
import com.qf.service.DingDanService;
import com.qf.service.ProductService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

/**
 * @author 小宝
 * @date 2019/10/6
 * @Time 9:36
 */
@RestController
public class ProductController {

    @Resource
    private ProductService productService;

    @Resource
    private DingDanService dingDanService;

    @Resource
    private UserRepository userRepository;

    @RequestMapping("/selectAll")
    public List<Product> selectProduct(){
       return productService.selectProduct();
    }

    @RequestMapping(value = "/selectByStatus",method = RequestMethod.POST)
    public List<Product> selectByStatus(@RequestParam("status")Integer status){
        return productService.selectProductByStatus(status);
    }

    @RequestMapping("/selectByDays")
    public List<Product> selectByDays(@RequestParam("days")Integer days){
        return productService.selectByDays(days);
    }

    @RequestMapping("/selectById")
    public Product selectById(@RequestParam("id")Integer id){
        return productService.selectById(id);
    }

    @RequestMapping("/selectProductById")
    public Product selectProductById(@RequestParam("pid")Integer pid){
        return productService.selectProductById(pid);
    }

    @RequestMapping("/insertDingDan")
    public String insertDingDan(@RequestBody DingDan dingDan){
        dingDan.setTime(new Date());
        return dingDanService.insertDingDan(dingDan)==0?"购买失败":"购买成功";
    }
    @RequestMapping(value = "/selectDingDanByUname",method = RequestMethod.POST)
    public List<Order> selectDingDanByUname(@RequestParam("uname")String  uname){

        User user=userRepository.findByUname(uname);
        return dingDanService.selectDingDanByUname(user.getUid());
    }


}
