<%--
  Created by IntelliJ IDEA.
  User: asus
  Date: 2021/10/24
  Time: 13:00
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>

<%--引入其他jsp文件--%>
<jsp:include page="error.jsp"></jsp:include>
<%--转发--%><%--还可以携带参数--%>
<jsp:forward page="JspTag2.jsp">
    <jsp:param name="name" value="jiji"/>
</jsp:forward>

</body>
</html>
