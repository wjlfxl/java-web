<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
   if(session.getAttribute("loginUser")!=null)
   {
     session.removeAttribute("loginUser");
     Integer userCount=(Integer)application.getAttribute("userCount");
     application.setAttribute("userCount",new Integer(userCount.intValue()-1));  
   }
  response.sendRedirect("login.jsp");
%>


