package com.qf.service;

import com.qf.domain.User;

/**
 * @author HeXiaoH
 * @date 2019/10/2 13:44
 */
public interface UserService {
    /**
     *
     * 验证
     */
    String judge(String utel);
    /**
     *
     * 比对验证码
     */
    String yzm(String utel, String code);
    /**
     *
     * 注册用户
     */
    String registered(User user);
}
