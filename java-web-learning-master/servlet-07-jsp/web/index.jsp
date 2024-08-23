<%@ page import="java.util.Date" %>
<%--
  Created by IntelliJ IDEA.
  User: asus
  Date: 2021/10/23
  Time: 17:57
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
  <head>
    <title>jsp基本语法</title>
  </head>
  <body>
  <%--jsp表达式--%>
  <%--
  将程序结果输出到客户端
  <%=变量或表达式%>
  --%>
  <%=new Date()%>
  <%--jsp脚本片段--%>
  <%
    int sum=0;
    for (int i=1;i<=100;i++){
      sum+=i;
    }
    out.println("<h1>"+sum+"</h1>");
  %>

  <%--可以在代码中嵌入html元素 输出5个hello--%>
  <%
    for(int i=1;i<=5;i++){
  %>
    <h1>hello  <%=i%></h1>
  <%
    }
  %>


  <%--
    <%!%>可以定义全局变量(jsp声明)
  --%>
<%!
    static {
      System.out.println("Loading");
    }
%>


  </body>
</html>
