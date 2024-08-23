package com.zhong.wu;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author wuduan
 * @version 1.8
 * @date 2022/1/16 20:15
 */
public class HelloServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("HELLO");
        
        //this.getInitParameter()初始化参数
        //this.getServletConfig();Servlet配置
        //this.getServletContext();Servlet上下文
        ServletContext servletContext = this.getServletContext();
        String username="吾褍";
        servletContext.setAttribute("username",username);//将一个数据保存在了ServletContext中，名字为：username--值为username


    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doPost(req, resp);
    }
}
