package com.wang.servlet;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class Reget extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        ServletContext context=this.getServletContext();
        //设置请求转发的路径（Servlet路径,将getParam的数据转发到reGet）
       RequestDispatcher dispatcher= context.getRequestDispatcher("/getParam");
        //设置请求转发
        dispatcher.forward(req,resp);
    }
}
