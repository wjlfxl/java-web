<%--
  Created by IntelliJ IDEA.
  User: asus
  Date: 2021/10/22
  Time: 20:00
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
  <head>
    <title>$Title$</title>
  </head>
  <body>
  <h1 style="text-align: center">登录</h1>
  <form style="text-align: center" action="${pageContext.request.contextPath}/login" method="post">
    名字：<input type="text" name="username"><br>
    密码：<input type="password" name="pwd"><br>
    爱好：<input type="checkbox" name="hobbys" value="1">1
    <input type="checkbox" name="hobbys" value="2">2
    <input type="checkbox" name="hobbys" value="3">3
    <input type="checkbox" name="hobbys" value="4">4
    <input type="checkbox" name="hobbys" value="5">5
    <br>
    <input type="submit" value="提交">
  </form>
  </body>
</html>
