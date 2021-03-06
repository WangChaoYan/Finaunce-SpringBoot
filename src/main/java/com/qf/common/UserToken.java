package com.qf.common;

import org.apache.shiro.authc.UsernamePasswordToken;

/**
 * @author HeXiaoH
 * @date 2019/10/8 20:52
 */
public class UserToken extends UsernamePasswordToken {
    private String loginType;

    public UserToken(final String username,final String password,final String loginType) {
        super(username,password);
        this.loginType = loginType;
    }

    public String getLoginType() {
        return loginType;
    }

    public void setLoginType(String loginType) {
        this.loginType = loginType;
    }
}
