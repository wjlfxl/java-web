package com.zhong.wuduan.filter;

import javax.servlet.*;
import java.io.IOException;

/**
 * @author wuduan
 * @version 1.8
 * @date 2022/2/20 21:58
 */
public class CharacterEncodingFilter implements Filter {

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        request.setCharacterEncoding("utf-8");
        response.setCharacterEncoding("utf-8");
        chain.doFilter(request,response);
    }

}
