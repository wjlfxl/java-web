package com.zhong.wuduan.servlet;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author wuduan
 * @version 1.8
 * @date 2022/2/16 19:05
 */
public class LoginServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //获取前端数据
        String username = req.getParameter("username");
        if(username!=null&&username.equals("admin")){
            //登录成功
            req.getSession().setAttribute("USER_SESSION",req.getSession().getId());
            resp.sendRedirect("/sys/success.jsp");
        }else{
            //登录失败
            resp.sendRedirect("/error.jsp");
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }
}
