package com.qf.shiro;

import com.qf.dao.UserRepository;
import com.qf.domain.User;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.util.ByteSource;

import javax.annotation.Resource;

/**
 * @author HeXiaoH
 * @date 2019/10/2 13:37
 */
public class UserRealm extends AuthorizingRealm {
    @Resource
    private UserRepository userRepository;

    /**权限*/
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals) {
        return null;
    }

    /**登陆*/
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {
        //得到用户输入的username
        String username = (String) token.getPrincipal();
        User user = userRepository.findByUname(username);
        SimpleAuthenticationInfo simpleAuthenticationInfo=new SimpleAuthenticationInfo(username,user.getUpassword(),ByteSource.Util.bytes(username),getName());
        return simpleAuthenticationInfo;
    }

}