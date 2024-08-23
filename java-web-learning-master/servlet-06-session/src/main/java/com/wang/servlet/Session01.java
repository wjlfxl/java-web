package com.wang.servlet;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;

public class Session01 extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        //设置编码
        req.setCharacterEncoding("utf-8");
        resp.setCharacterEncoding("utf-8");
        //输出对象方法
        PrintWriter writer = resp.getWriter();
       /* 获取Session(由于是服务器给客户端（浏览器）创建Session对象，
            所以我们只能从客户端获取Session,所以使用request)
        */
        HttpSession session = req.getSession();
        //给Seesion设置一些值
        session.setAttribute("name","王");


        //将SessionId输出到浏览器
        writer.write(session.getId());
        //判断Session是不是新的
        writer.print(session.isNew());
        //输出我们设置的值
        writer.print((String)session.getAttribute("name"));

       /*
           //注销session
           session.invalidate();
        */


    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }
}
