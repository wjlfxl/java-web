<%--
  Created by IntelliJ IDEA.
  User: asus
  Date: 2021/10/21
  Time: 19:40
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
  <head>
    <title>$Title$</title>
  </head>
  <body>
  <%--路径需要寻找到项目路径  pageContext.request.contextPath代表当前项目   action：提交到后端的路径--%>
  <form action="${pageContext.request.contextPath}/request" method="get">
    用户名：<input type="text" name="username"> <br>
    密码：<input type="password" name="pwd"><br>
    <input type="submit" value="提交">
  </form>
  </body>
</html>
