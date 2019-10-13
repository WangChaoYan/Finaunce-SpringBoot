package com.qf.config;

import com.qf.domain.User;
import com.qf.service.UserService;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.subject.Subject;

import javax.annotation.Resource;
import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author 小宝
 * @date 2019/10/12
 * @Time 10:46
 */
@WebFilter(filterName = "LoginFilter", urlPatterns = "/pay")
public class LoginFilter implements Filter {
    @Resource
    UserService userService;

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain filterChain) throws IOException, ServletException {

        HttpServletRequest req = (HttpServletRequest) request;
        HttpServletResponse resp = (HttpServletResponse) response;
        Subject subject= SecurityUtils.getSubject();        //与shiro整合有错
        String principal=(String)subject.getPrincipal();
        User user=userService.findUser(principal);
        Integer uid=user.getUid();
        if(uid!=null){
            filterChain.doFilter(request,response);
        }else{
            resp.sendRedirect("localhost:8080/login");
        }

    }

    @Override
    public void init(FilterConfig filterConfig) {
        System.out.println("进入过滤器");
    }
}
