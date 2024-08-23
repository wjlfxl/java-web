package com.zhong.wu.servlet;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.URLEncoder;
import java.util.Date;

/**
 * @author wuduan
 * @version 1.8
 * @date 2022/1/25 20:55
 */
//中文数据传递
public class CookieDemo03 extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("utf-8");
        resp.setCharacterEncoding("utf-8");
        resp.setContentType("text/html;charset=UTF-8");

        PrintWriter writer = resp.getWriter();
        //Cookie，服务器端从客户端获取
        Cookie[] cookies = req.getCookies();//这里返回数组，说明cookie可能存在多个
        writer.write("你上一次访问的时间是");
        for (Cookie cookie : cookies) {
            //获得cookie的名字
            if (cookie.getName().equals("name")) {
                //获取cookie中的值

                String value = cookie.getValue();
                System.out.println(value);
                writer.write(value);
            }

        }

        //服务端给客户端响应一个cookie
        Cookie cookie = new Cookie("name", "吾褍");
        resp.addCookie(cookie);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doPost(req, resp);
    }
}
