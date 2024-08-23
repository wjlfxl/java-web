package com.wang.servlet;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class Getpop extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        ServletContext context=this.getServletContext();
        //相对路径(使用我们生成的项目的路径，就是target包)
        InputStream in=context.getResourceAsStream("/WEB-INF/classes/db.properties");
        Properties pop=new Properties();
        pop.load(in);
        String user=pop.getProperty("username");//以键值对获取
        String pwd=pop.getProperty("password");
        resp.getWriter().print(user+pwd);
    }
}
