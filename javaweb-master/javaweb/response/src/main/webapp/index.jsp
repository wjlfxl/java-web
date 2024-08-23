<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>

<body>
<h2>Hello World!</h2>
<%--这里提交的路径，需要寻找到项目的路径 --%>
<%-- ${pageContext.request.contextPath}代表项目的路径--%>

<from action="${pageContext.request.contextPath}/rt" method="get">

    用户名:<input type="text" name="username">
    密码:<input type="text" name="password">
    <input type="submit">
</from>
</body>
</html>
