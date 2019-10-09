package com.qf.controller;

import com.qf.domain.Admin;
import com.qf.service.AdminService;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @author HeXiaoH
 * @date 2019/10/2 14:35
 */
@RestController
public class AdminController {
    @Resource
    private AdminService adminService;

    /**
     * 登陆
     */
    @RequestMapping(value = "/AdminLogin",method = RequestMethod.POST)
    public String AdminLogin(@RequestBody Admin admin){
        String aname = admin.getAname();
        String apassword = admin.getApassword();
        if(aname!=""&&aname!=null&&apassword!=""&&apassword!=null){
            Subject subject = SecurityUtils.getSubject();
            UsernamePasswordToken token = new UsernamePasswordToken(aname,apassword);
            try {
                subject.login(token);
                if(subject.isAuthenticated()){
                    return "success";
                }else {
                    return "fail";
                }
            }catch (Exception e){
                return "fail";
            }
        }
        return "值不能为空";
    }
}