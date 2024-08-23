package com.wang.servlet;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class HelloServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("hello");
        //获取ServletContext对象
        ServletContext context=this.getServletContext();
        String username="wang";
        //将username以键值对的形式放入ServletContext
        context.setAttribute("username",username);
    }
}
