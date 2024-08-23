package servlet;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

//@WebServlet(name = "Servlet", value = "/login")
public class HelloServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        String method = request.getParameter("method");

        System.out.println("浏览器发出请求时的完整URL，包括协议 主机名 端口(如果有): " + request.getRequestURL());
        System.out.println("浏览器发出请求的资源名部分，去掉了协议和主机名: " + request.getRequestURI());
        System.out.println("请求行中的参数部分: " + request.getQueryString());
        System.out.println("浏览器所处于的客户机的IP地址: " + request.getRemoteAddr());
        System.out.println("浏览器所处于的客户机的主机名: " + request.getRemoteHost());
        System.out.println("浏览器所处于的客户机使用的网络端口: " + request.getRemotePort());
        System.out.println("服务器的IP地址: " + request.getLocalAddr());
        System.out.println("服务器的主机名: " + request.getLocalName());
        System.out.println("得到客户机请求方式: " + request.getMethod());

        if (method.equals("add")){
            request.getSession().setAttribute("msg","执行了add方法");
        }
        if (method.equals("delete")){
            request.getSession().setAttribute("msg","执行了delete方法");
        }

        request.getRequestDispatcher("/WEB-INF/jsp/success.jsp").forward(request,response);

//            服务端跳转可以看到浏览器的地址依然是/login 路径，并不会变成success.html
//            request.getRequestDispatcher("success.html").forward(request, response);
//        else
//            可以观察到，浏览器地址发生了变化
//            response.sendRedirect("fail.html");

    }
}
