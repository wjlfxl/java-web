package com.zhong.wu.servlet;

import org.apache.jasper.runtime.HttpJspBase;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;

/**
 * @author wuduan
 * @version 1.8
 * @date 2022/1/23 23:50
 */
public class CookieDemo01 extends HttpServlet {

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
            if (cookie.getName().equals("lastLoginTime")) {
                //获取cookie中的值

                String value = cookie.getValue();
                System.out.println(value);
                long lastLoiginTime = Long.parseLong(value);
                Date date = new Date(lastLoiginTime);
                writer.write(date.toLocaleString());


            }

        }
        /*
        这里有一个编写错误，应该是由于cookie的机制，取到的cookie不可能为空
        但是可以判断cookie数组的长度来判断cookie是否真的为空
         //判断cookie是否存在
        if (cookies!=null) {
            //如果存在怎么办
            writer.write("你上一次访问的时间是");
            for (Cookie cookie : cookies) {
                //获得cookie的名字
                if (cookie.getName().equals("lastLoginTime")) {
                    //获取cookie中的值
                    String value = cookie.getValue();
                    long lastLoiginTime = Long.parseLong(value);
                    Date date = new Date(lastLoiginTime);
                    writer.write(date.toLocaleString());


                }
            }
        }else{
            writer.write("这是您第一次访问");
        }

         */
        //服务端给客户端响应一个cookie
        Cookie cookie = new Cookie("lastLoginTime",System.currentTimeMillis()+"");
        //设置cookie有效期
        cookie.setMaxAge(24*60*60);
        resp.addCookie(cookie);

    }


    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doPost(req, resp);
    }
}
