<%--
  Created by IntelliJ IDEA.
  User: zhongwuduan
  Date: 2022/2/13
  Time: 22:16
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<%-- jsp:clude--%>
<jsp:forward page="/jsptag2.jsp">
    <jsp:param name="value1" value="value1"/>
    <jsp:param name="value2" value="value2"/>
</jsp:forward>
</body>
</html>
