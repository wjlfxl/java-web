package com.zhong.wuduan.servlet;

import com.zhong.wuduan.pojo.User;
import com.zhong.wuduan.utils.sendMail;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author wuduan
 * @version 1.8
 * @date 2022/3/2 17:42
 */
public class RegisterServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String username = req.getParameter("username");
        String password = req.getParameter("password");
        String email = req.getParameter("email");

        System.out.println(username);
        System.out.println(password);
        System.out.println(email);
        User user = new User(username, password, email);

        //用户注册成功，给用户发一封邮件
        //使用线程专门来发送邮件，防止出现耗时，
        sendMail sendMail = new sendMail(user);
        //启动线程
        sendMail.start();

        //注册用户
        req.setAttribute("message","注册成功，我们已发送一封注册信息的电子邮件，请注意查收");
        req.getRequestDispatcher("info.jsp").forward(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }
}
