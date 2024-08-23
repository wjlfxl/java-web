<%--
  Created by IntelliJ IDEA.
  User: zhongwuduan
  Date: 2022/2/13
  Time: 22:25
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%-- 引入JSTL标签库的核心标签--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h4>if测试</h4>
<hr>
<form action="coreif.jsp" method="get">
    <%-- EL表达式获取表单中的数据
    ${param.参数名}
    --%>
    <input type="text" name="username" value="${param.username}">
    <input type="submit" value="登录">
</form>
<%--判断如果提交的用户是管理员，则登陆成功
 --%>
<c:if test="${param.username=='admin'}" var="isAdimin">
    <c:out value="管理员欢迎您!"/>
</c:if>
<%--自闭合标签 --%>
<c:out value="${isAdimin}"/>
</body>
</html>
