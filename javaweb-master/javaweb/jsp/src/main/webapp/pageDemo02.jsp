<%--
  Created by IntelliJ IDEA.
  User: zhongwuduan
  Date: 2022/2/13
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
  //从pageContext中取出，我们通过寻找的方式来实现
  String name1 = (String)pageContext.findAttribute("name1");
  String name2 = (String)pageContext.findAttribute("name2");
  String name3 = (String)pageContext.findAttribute("name3");
  String name4 = (String)pageContext.findAttribute("name4");
  String name5 = (String)pageContext.findAttribute("name5");


%>

<%-- 使用EL表达式输出--%>
<h1>取出的值</h1>
<h3>${name1}</h3>
<h3>${name2}</h3>
<h3>${name3}</h3>
<h3>${name4}</h3>
<h3>${name5}</h3>
<%--EL表达式会过滤空值 --%>
<h3><%=name5%></h3>
</body>
</html>
