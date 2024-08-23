<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page import="java.util.ArrayList" %><%--
  Created by IntelliJ IDEA.
  User: zhongwuduan
  Date: 2022/2/14
  Time: 17:45
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<%
    ArrayList<String> strings = new ArrayList<>();
    strings.add("张三");
    strings.add("李四");
    strings.add("王五");
    strings.add("赵六");
    strings.add("田七");
    request.setAttribute("list",strings);
%>

<c:forEach var="people" items="${list}">
    <c:out value="${people}"/>
    <br>
</c:forEach>
<hr>
<c:forEach var="people" items="${list}" begin="1" end="3"  step="2">
    <c:out value="${people}"/>
</c:forEach>
</body>
</html>
