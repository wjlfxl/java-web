package com.wang.filter;

import javax.servlet.*;
import java.io.IOException;

public class EncodingFiler implements Filter {
    //初始化  服务器只要一启动就开始初始化
    public void init(FilterConfig filterConfig) throws ServletException {
        System.out.println("过滤器初始化");
    }

    //实现过滤的内容
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        servletRequest.setCharacterEncoding("utf-8");
        servletResponse.setCharacterEncoding("utf-8");
        servletResponse.setContentType("text/html");
        //这个必须写，否则无法是程序运行下去
        filterChain.doFilter(servletRequest,servletResponse);
    }

    //销毁   只有服务器关闭时才销毁
    public void destroy() {
        System.out.println("过滤器销毁");
    }
}
