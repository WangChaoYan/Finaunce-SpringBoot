package com.qf.service.impl;

import com.aliyuncs.exceptions.ClientException;
import com.qf.dao.UserCodeRepository;
import com.qf.dao.UserRepository;
import com.qf.domain.User;
import com.qf.domain.UserCode;
import com.qf.service.UserService;
import com.qf.utils.AliyunSmsUtils;
import org.apache.shiro.crypto.hash.SimpleHash;
import org.apache.shiro.util.ByteSource;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @author HeXiaoH
 * @date 2019/10/2 13:44
 */
@Service
public class UserServiceImpl implements UserService {
    @Resource
    private UserRepository userRepository;
    @Resource
    private UserCodeRepository userCodeRepository;

    @Override
    public String judge(String utel){
        User user = userRepository.findByUtel(utel);
        if(user==null){
            try {
                //发送短信验证码
                String code = AliyunSmsUtils.sendCode(utel);
                //存储验证码
                UserCode userCode = userCodeRepository.findByUtel(utel);
                if(userCode==null){
                    userCode=new UserCode();
                    userCode.setUtel(utel);
                    userCode.setStatus(1);
                    userCode.setCode(code);
                    userCodeRepository.save(userCode);
                }else {
                    userCode.setCode(code);
                    userCodeRepository.saveAndFlush(userCode);
                }
                return "发送成功";
            } catch (ClientException e) {
                e.printStackTrace();
                return "发送失败";
            }

        }
        return "用户已存在";
    }

    @Override
    public String yzm(String utel, String code) {
        UserCode userCode = userCodeRepository.findByUtel(utel);
        if(code.equals(userCode.getCode())){
            return "success";
        }
        return "fail";
    }

    @Override
    public String registered(User user) {
        //密码加密
        String upassword = user.getUpassword();
        //加密算法
        String hashAlgorithName = "MD5";
        //登陆时的密码
        String password = upassword;
        //加密次数
        int hashIterations =1024;
        //使用登录名做为salt
        ByteSource credentialsSalt = ByteSource.Util.bytes(user.getUname());
        SimpleHash simpleHash = new SimpleHash(hashAlgorithName, password, credentialsSalt, hashIterations);
        user.setUpassword(simpleHash.toString());
        Date date =new Date();
        SimpleDateFormat dateformat = new SimpleDateFormat("yyyy/MM/dd");
        String time = dateformat.format(date);
        user.setCreatetime(time);
        user.setStatus(1);
        User save = userRepository.save(user);
        if(save!=null){
            return "success";
        }else {
            return "fail";
        }
    }

    @Override
    public User findUser(String uname) {
        return userRepository.findByUname(uname);
    }
}
