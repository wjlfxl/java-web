package com.wang.servlet;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class GetUsername extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        ServletContext context=this.getServletContext();
        //ServletContext本身是object类型，由于获取的对象是String类型，所以我们需要强转
        String username=(String) context.getAttribute("username");
        resp.getWriter().print(username);
    }
}
