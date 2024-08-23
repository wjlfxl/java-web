<%--
  Created by IntelliJ IDEA.
  User: asus
  Date: 2021/10/23
  Time: 22:35
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%--发生出错误就跳转到erroe.jsp--%>
<%@ page errorPage="error.jsp" %>
<html>
<head>
    <title>test</title>
</head>
<body>

<%
    int i=1/0;
%>
</body>
</html>
