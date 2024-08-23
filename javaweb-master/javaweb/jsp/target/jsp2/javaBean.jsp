<%--
  Created by IntelliJ IDEA.
  User: zhongwuduan
  Date: 2022/2/14
  Time: 20:31
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<%

%>

<jsp:useBean id="person" class="com.zhong.wuduan.pojo.Person" scope="page"/>
<jsp:setProperty name="person" property="address" value="福建"/>
<jsp:setProperty name="person" property="id" value="1"/>
<jsp:setProperty name="person" property="age" value="18"/>
<jsp:setProperty name="person" property="name" value="wudaun"/>

姓名：<jsp:getProperty name="person" property="name"/>
ID：<jsp:getProperty name="person" property="id"/>
年龄：<jsp:getProperty name="person" property="age"/>
地址：<jsp:getProperty name="person" property="address"/>
</body>
</html>
