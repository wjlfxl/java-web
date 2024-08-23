package com.zhong.wuduan.filter;

import com.zhong.wuduan.pojo.User;
import com.zhong.wuduan.util.Constants;

import javax.servlet.*;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author wuduan
 * @version 1.8
 * @date 2022/2/22 20:34
 */
public class SysFilter implements Filter {
    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        HttpServletRequest request1 = (HttpServletRequest) request;
        HttpServletResponse response1 = (HttpServletResponse) response;
        //过滤器，从Session中获取用户
        User user = (User) request1.getSession().getAttribute(Constants.USER_SESSION);
        if(user==null){
            //已经被移除或者被注销，或者没登录
            response1.sendRedirect(request1.getContextPath()+"/error.jsp");
        }else{
            chain.doFilter(request,response);
        }
    }

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        Filter.super.init(filterConfig);
    }

    @Override
    public void destroy() {
        Filter.super.destroy();
    }
}
