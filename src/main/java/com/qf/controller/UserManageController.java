package com.qf.controller;

import com.qf.Response.ResponseUser;

import com.qf.domain.DingDan;
import com.qf.domain.LoanOrder;
import com.qf.domain.User;
import com.qf.domain.ZiChan;
import com.qf.service.UserManageService;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;


@RestController
public class UserManageController {

    @Autowired
    private UserManageService userManageService;

    @RequiresPermissions(value = {"user"})
    @RequestMapping("/manageSelect/{page}/{size}")//全查，分页
    public ResponseUser manageSelect(@PathVariable("page")Integer page, @PathVariable("size")Integer size){//返回User
            return userManageService.findAll(page,size);
    }

    @RequiresPermissions(value = {"user"})//权限，使用user_insert,  还是user
    @RequestMapping("/manageInsert")//新增
    public User manageInsert(@RequestBody User user){
            return userManageService.save(user);
    }

    @RequiresPermissions(value = {"user"})
    @RequestMapping("/manageDelete")//删除
    public String manageDelete(@RequestBody User user){
        System.out.println(user);

        return  userManageService.managedelete(user);//返回一个删除成功
    }

    @RequiresPermissions(value = {"user"})
    @RequestMapping("/manageSelectById") //修改的查
    public User manageSelectById(@RequestBody User user){
        return  userManageService.selectById(user);
    }

    @RequiresPermissions(value = {"user"})
    @RequestMapping("/manageUpdate")//修改的改
    public User manageUpdate(@RequestBody User user){
       return userManageService.manageupdate(user);
    }

    //单用户查询
    @RequestMapping("/findUserOne")
    //public User findUserOne(@PathVariable("uid") Integer uid){
    public List<User> findUserOne(@RequestBody User user){
                                                    
        List<User> userOne = userManageService.findUserOne(user);
        System.out.println(userOne);
        return  userOne;

    }
/*
* 以下是资金，展示，计算，展示订单，贷款金额   还是公用一个controller
* */
    //少一个表，资产表，借贷，商品，产生金钱变化，这里只负责展示金额count
    //公司资产查询
    //资金，去查询，资金表的金额，还有一个详细的资金出入表的记录，展示


    @RequiresPermissions(value = {"user"})
    @RequestMapping("/manageEAM")      //资金总额计算
    public ZiChan manageEAM(){//BigDecimal 钱的单位类型


        ZiChan ziChan = userManageService.manageEAM();
        
        System.out.println(ziChan);
        return ziChan;
    }

    @RequestMapping("/manageDingdan/{page}/{size}")
    public ResponseUser manageDingdan(@PathVariable("page")Integer page, @PathVariable("size")Integer size){
        ResponseUser responseUser = userManageService.manageDingdan(page, size);
        
        return responseUser;

    }

    @RequestMapping("/manageLoanOrder")
    public List<LoanOrder> manageLoanOrder(){
        List<LoanOrder> loanOrders = userManageService.manageLoanOrder();
        
        return loanOrders;
    }

    //退出
    @RequestMapping("/logout")//退出还没写。
    public String logout(){
        Subject subject=SecurityUtils.getSubject();
        subject.logout();
        return "success";
    }

}
