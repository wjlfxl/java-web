<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<html>
  <head>
    <title>My JSP 'error.jsp' starting page</title>
    <Link rel="stylesheet" type="text/css" href="style/style.css"/>
    
  </head>
  
  <body>
  <div class="t"  align="center">
<BR/><BR/>
   <font color="red"><%=request.getParameter("msg") %></font>
   <BR/><BR/>
   
   <input type="button" value="返回" onclick="window.history.back();"/>
   <BR/><BR/>
   
   </div>
  </body>
</html>
