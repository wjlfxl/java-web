package com.zhong.wuduan.filter;


import javax.servlet.*;
import java.io.IOException;

/**
 * @author wuduan
 * @version 1.8
 * @date 2022/2/14 23:29
 */
public class CharacterEncodingFilter implements Filter {

    //Chain:链
    /*
    1.过滤中的所有代码，在过滤特定的请求时执行
    2.
     */
    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
    request.setCharacterEncoding("utf-8");
    response.setCharacterEncoding("utf-8");
    response.setContentType("text/html;charset=UTF-8");

        System.out.println("CharacterEncodingFilter执行前");
        chain.doFilter(request,response);//让请求继续走，如果不写，程序在这里就被拦截了，不会接着去走其他拦截器
        System.out.println("CharacterEncodingFilter执行后");
    }
    //初始化
    //在web服务器启动的时候就已经完成初始化
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        Filter.super.init(filterConfig);
        System.out.println("CharacterEncodingFilter已初始化");
    }
    //销毁
    //在web服务器关闭的时候，过滤器会销毁
    @Override
    public void destroy() {
        Filter.super.destroy();
        System.out.println("CharacterEncodingFilter已销毁");
    }
}
