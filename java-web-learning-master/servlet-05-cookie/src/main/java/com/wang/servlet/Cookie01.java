package com.wang.servlet;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;

public class Cookie01 extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //解决中文乱码问题
        req.setCharacterEncoding("utf-8");
        resp.setCharacterEncoding("utf-8");

        PrintWriter writer = resp.getWriter();

        //new一个cookie    System.currentTimeMillis()获取当前时间
        Cookie cookie = new Cookie("LastLoginTime", System.currentTimeMillis() + "");
        //给cookie设置存在时间（一天）
        cookie.setMaxAge(24 * 60 * 60);
        //给浏览器响应一个cookie
        resp.addCookie(cookie);


        //在从浏览器获取cookie
        Cookie[] cookies = req.getCookies();
        //将cookie输出到浏览器
        for (Cookie cookie1 : cookies) {
            if (cookie1.getName().equals("LastLoginTime")) {
                //一系列转化   最后转化为时间
                long l = Long.parseLong(cookie1.getValue());
                Date date = new Date(l);
                writer.write(date.toLocaleString());
            }
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }
}
