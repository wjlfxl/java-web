<%--
  Created by IntelliJ IDEA.
  User: asus
  Date: 2021/10/24
  Time: 13:18
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%--引入jstl核心标签库--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <form action="JstlTag.jsp" method="get">
        <%--使用EL表达式获取数值--%>
        <input type="text" name="username" value="${param.username}">
        <input type="submit" value="提交">
    </form>

<%--若登录的是admin，我们就让他登录成功--%>
<c:if test="${param.username=='admin'}" var="isAdmin">
    <c:out value="欢迎您"/>
</c:if>
<c:out value="${isAdmin}"></c:out>


<%
    if(((String)request.getParameter("username")).equals("admin")){
        out.write("欢迎");
    }
%>
</body>
</html>
