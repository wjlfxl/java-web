package com.wang.servlet;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class Login extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("utf-8");
        resp.setCharacterEncoding("utf-8");
        String username=req.getParameter("username");
        String pwd=req.getParameter("pwd");
        String hobbys[]=req.getParameterValues("hobbys");
        System.out.println(username+","+pwd);
        for(String hobby: hobbys){
            System.out.println(hobby);
        }
        //请求转发
        req.getRequestDispatcher("/success.jsp").forward(req,resp);
    }
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }
}
