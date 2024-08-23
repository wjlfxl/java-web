package com.wang.servlet;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Random;

public class VerificationCode extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //浏览器5秒刷新一次
        resp.setHeader("refresh","5");
        //设置向浏览器响应的文件类型（图片类型）
        resp.setContentType("text/html");
        //浏览器有缓存，设置没有缓存
        resp.setDateHeader("expires",-1);
        resp.setHeader("Cache-Control","no-cache");
        resp.setHeader("Pragma","no-cache");
        PrintWriter writer=resp.getWriter();
        writer.print(getNum());
    }
    //生成随机数
    private int getNum(){
        Random random=new Random();
        int num=random.nextInt(9999999);//7位数
        return num;
    }
}
