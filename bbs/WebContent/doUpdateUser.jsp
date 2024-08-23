<%@ page language="java" import="java.util.*,com.entity.*" pageEncoding="UTF-8"%>
<%
request.setCharacterEncoding("utf-8");
    String userName=request.getParameter("userName");
    String password=request.getParameter("pass1");
    String head=request.getParameter("head");
    User user=(User)session.getAttribute("loginUser");
    if(user!=null&&userName!=null&&password!=null)
    {
    user.setHead(head);
    user.setPassword(password);
    user.setUserName(userName);
    session.setAttribute("loginUser",user);
    }
    response.sendRedirect("index.jsp");
%>

