package com.qf.utils;

import javax.servlet.http.HttpServletRequest;

/**
 * @author HeXiaoH
 * @date 2019/10/14 11:53
 */
public class WebUtilsPro {
    /**
     * 是否是Ajax请求
     *
     * @param request
     * @return
     * @author SHANHY
     * @create 2017年4月4日
     */
    public static boolean isAjaxRequest(HttpServletRequest request) {
        String requestedWith = request.getHeader("x-requested-with");
        if (requestedWith != null && requestedWith.equalsIgnoreCase("XMLHttpRequest")) {
            return true;
        } else {
            return false;
        }
    }

}
