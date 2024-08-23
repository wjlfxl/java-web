<%--
  Created by IntelliJ IDEA.
  User: zhongwuduan
  Date: 2022/3/2
  Time: 19:37
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<form action="${pageContext.request.contextPath}/RegisterServlet.do" method="post">
    username:<input type="text" name="username"> </br>
    password:<input type="password" name="password"></br>
    邮箱:<input type="text" name="email"></br>
    <input type="submit" value="注册">
</form>
</body>
</html>
