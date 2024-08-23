package com.zhong.wuduan.servlet;

import com.zhong.wuduan.pojo.User;
import com.zhong.wuduan.service.UserServiceImpl;
import com.zhong.wuduan.util.Constants;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author wuduan
 * @version 1.8
 * @date 2022/2/21 21:22
 */
public class LoginServlet extends HttpServlet {
    //Servlet:控制层调用业务层代码

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("LoginServlet--start---");
        //获取用户名和密码
        String usercode = req.getParameter("userCode");
        String userPassword = req.getParameter("userPassword");

        //和数据库中的密码进行对比,调用业务层代码,



        //目前是没有比对密码的


        
        UserServiceImpl userService = new UserServiceImpl();
        User user = userService.login(usercode, userPassword);//这里已经把登录的人查出来了
        if(user!=null){
            //查有此人，可以登录
            //将用户的信息放到Session中
            req.getSession().setAttribute(Constants.USER_SESSION,user);
            //跳转到内部主页
            System.out.println(userPassword);
            resp.sendRedirect("jsp/frame.jsp");
        }else{
            //查无此人
            //转发会登录页面,顺带提示提示用户名或者密码错误
            req.setAttribute("error","用户名或者密码不正确");
            req.getRequestDispatcher("login.jsp").forward(req,resp);
        }

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
       doGet(req, resp);
    }
}
