package com.plasticine.filter;

import com.plasticine.pojo.User;
import com.plasticine.util.Constants;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * 控制访问权限，凡是webapp目录下的jsp中的所有页面都需要登录后才能访问
 */
public class JspFilter implements Filter {
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        // 将 servletRequest 和 servletResponse 强制转换一下
        HttpServletRequest request = (HttpServletRequest) servletRequest;
        HttpServletResponse response = (HttpServletResponse) servletResponse;

        // 获取 session 中的 USER_SESSION
        User userSession = (User) request.getSession().getAttribute(Constants.USER_SESSION);

        // 判断 userSession 是否存在 -- 不存在即未登录
        if (userSession == null) {
            response.sendRedirect(request.getContextPath() + "/error.jsp");
        } else {
            // 登录了，让 filterChain 继续往下执行
            filterChain.doFilter(servletRequest, servletResponse);
        }
    }
}
