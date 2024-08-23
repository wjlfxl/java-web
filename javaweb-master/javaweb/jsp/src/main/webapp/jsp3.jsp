<%--
  Created by IntelliJ IDEA.
  User: zhongwuduan
  Date: 2022/2/12
  Time: 21:05
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>

<%@ include file="common/header.jsp"%>
<h1>网页主体</h1>
<%@include file="common/footer.jsp"%>

<%-- JSP标签--%>
<%--在底层Servlet会将两个页面的代码写入当前JSP页面对应的Servlet页面 --%>
<%-- 这种写法本质还是三个页面--%>
<%-- 要注意变量的重复定义问题
在单独的一个页面内定义的变量是局部变量，而在总页面处定义的变量是全局变量
--%>
<jsp:include page="common/header.jsp"/>
<h1>网页主体</h1>
<%-- 在这里定义的变量如果出现重复将会直接报错--%>
<jsp:include page="common/footer.jsp"/>
</body>
</html>
