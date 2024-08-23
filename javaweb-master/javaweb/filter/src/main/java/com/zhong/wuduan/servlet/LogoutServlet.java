package com.zhong.wuduan.servlet;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author wuduan
 * @version 1.8
 * @date 2022/2/16 21:46
 */
public class LogoutServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        Object user_session = req.getSession().getAttribute("USER_SESSION");
        if(user_session!=null){
            req.getSession().removeAttribute("USER_SESSION");
        }
        resp.sendRedirect("/Login.jsp");
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException {
       doGet(req, resp);
    }
}
