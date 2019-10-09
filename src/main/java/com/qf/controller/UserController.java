package com.qf.controller;

import com.qf.domain.User;
import com.qf.domain.UserCode;
import com.qf.service.UserService;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

/**
 * @author HeXiaoH
 * @date 2019/10/2 14:35
 */
@RestController
public class UserController {
    @Resource
    private UserService userService;

    /**
     *
     *注册
     *
     */
    @RequestMapping(value = "/registered",method = RequestMethod.POST)
    public String registered(@RequestBody User user,HttpServletRequest request){
        HttpSession session = request.getSession();
        String utel = (String) session.getAttribute("tel");
        user.setUtel(utel);
        String message = userService.registered(user);
        return message;
    }

    /**
     *
     * 比对验证码
     */
    @RequestMapping(value = "/judgeCode",method = RequestMethod.POST)
    public String judgeCode(@RequestBody UserCode userCode,HttpServletRequest request){
        HttpSession session = request.getSession();
        String utel = (String) session.getAttribute("tel");
        String message = userService.yzm(utel, userCode.getCode());
        return message;
    }


    /**
     *
     * 注册验证  比对手机号，发送验证码
     */
    @RequestMapping(value = "/judgeTel",method = RequestMethod.POST)
    public String judgeTel(@RequestBody User user,HttpServletRequest request){
        String utel=user.getUtel();
        HttpSession session = request.getSession();
        session.setAttribute("tel",utel);
        String message = userService.judge(utel);
        return message;
    }


    /**
     * 登陆
     */
    @RequestMapping(value = "/loginVal",method = RequestMethod.POST)
    public String loginVal(@RequestBody User user){
        String username=user.getUname();
        String password=user.getUpassword();
        if(username!=""&&username!=null&&password!=""&&password!=null){
            System.out.println(username+"============================================="+password);
            Subject subject = SecurityUtils.getSubject();
            UsernamePasswordToken token = new UsernamePasswordToken(username,password);
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