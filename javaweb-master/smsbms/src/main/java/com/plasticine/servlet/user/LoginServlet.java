package com.plasticine.servlet.user;

import com.plasticine.pojo.User;
import com.plasticine.service.user.UserServiceImpl;
import com.plasticine.util.Constants;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

// Servlet --> 控制层，调用业务层代码
public class LoginServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        System.out.println("LoginServlet--start......");

        // 获取用户编号和密码
        String userCode = req.getParameter("userCode");
        String userPassword = req.getParameter("userPassword");

        // 调用业务层代码，让业务层代码去完成用户编号和密码的校验，然后获取用户对象
        UserServiceImpl userService = new UserServiceImpl();
        User user = userService.login(userCode, userPassword);

        // 能获取到 user 说明用户登陆成功，账号密码都正确
        if (user != null) {
            // 登陆成功，将用户对象放到 Session 中
            req.getSession().setAttribute(Constants.USER_SESSION, user);
            // 跳转到主页
            resp.sendRedirect("jsp/frame.jsp");
        } else {
            // 登录失败，转发到登录页面，顺便提示用户名和密码错误
            req.setAttribute("error", "用户名或密码不正确");
            req.getRequestDispatcher("login.jsp").forward(req, resp);

        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }
}
