package com.wang.servlet;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class RequestTest extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("进入请求");
        String username=req.getParameter("username");
        String pwd=req.getParameter("pwd");
        System.out.println(username+","+pwd);
        resp.sendRedirect("/s3/success.jsp");
    }
}
