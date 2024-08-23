<%--
  Created by IntelliJ IDEA.
  User: zhongwuduan
  Date: 2022/1/22
  Time: 23:31
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" pageEncoding="UTF-8" contentType="text/html; charset=UTF-8" %>
<html>
<head>
    <title>登录</title>
</head>
<body>
<h1>登录</h1>
<div style="text-align: center">
    <%-- 这里以表单表示的意思是，以post的方式提交表单，提交到我们的Login请求--%>
    <form action="${pageContext.request.contextPath}/login" method="post">
        用户:<input type="text" name="username"><br>
        密码:<input type="password" name="password"><br>
        爱好:
        <input type="checkbox" name="hobby" value="女孩">女孩
        <input type="checkbox" name="hobby" value="代码">代码
        <input type="checkbox" name="hobby" value="Terraria">Terraria
        <input type="checkbox" name="hobby" value="电影">电影

        <br>
        <input type="submit">
    </form>
</div>
</body>
</html>
