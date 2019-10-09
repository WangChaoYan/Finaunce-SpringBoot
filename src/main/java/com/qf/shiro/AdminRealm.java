package com.qf.shiro;

import com.qf.dao.AdminRepository;
import com.qf.dao.PermissionRepository;
import com.qf.domain.Admin;
import com.qf.domain.Permission;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.util.ByteSource;

import javax.annotation.Resource;
import java.util.Collection;
import java.util.HashSet;
import java.util.List;

public class AdminRealm extends AuthorizingRealm {
    @Resource
    private AdminRepository adminRepository;

    @Resource
    private PermissionRepository permissionRepository;
    /**权限*/
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals) {
        //得到用户名
        String username = (String) principals.getPrimaryPrincipal();
        List<Permission> list = permissionRepository.selectPermissionByAdminName(username);
        //HashSet底层由hashmap实现，不允许集合中有重复的值出现， 使用该方式时，需要重写equals（）和hashcode（）方法
        Collection set=new HashSet();

        for (Permission permission : list) {
            //将权限去重
            set.add(permission.getPname());
        }

        SimpleAuthorizationInfo simpleAuthorizationInfo = new SimpleAuthorizationInfo();
        simpleAuthorizationInfo.addStringPermissions(set);
        return simpleAuthorizationInfo;
    }

    /**登陆*/
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {
        //得到用户输入的username
        String aname = (String) token.getPrincipal();
        Admin admin = adminRepository.findByAname(aname);
        SimpleAuthenticationInfo simpleAuthenticationInfo=new SimpleAuthenticationInfo(admin.getAname(),admin.getApassword(),ByteSource.Util.bytes(admin.getAname()),getName());
        return simpleAuthenticationInfo;
    }

}
