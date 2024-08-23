package com.plasticine.servlet.user;

import com.plasticine.util.Constants;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class LogoutServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {

        // 将用户 session 中的 USER_SESSION 移除
        req.getSession().removeAttribute(Constants.USER_SESSION);
        // 重定向回登录页面
        resp.sendRedirect(req.getContextPath() + "/login.jsp");

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        doGet(req, resp);
    }
}
