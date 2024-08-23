<%--
  Created by IntelliJ IDEA.
  User: zhongwuduan
  Date: 2022/2/8
  Time: 21:44
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>$Title$</title>
</head>
<body>
<%-- JSP表达式
作用：用来将程序输出到客户端
<%= 变量或者表达式%>
--%>
<%= new java.util.Date()%>

<hr>
<%-- JSP脚本片段
--%>
<%
    int sum=0;
    for (int i = 0; i < 100; i++) {
        sum+=i;
    }
    out.println("<h1>Sum="+sum+"<h1>");
%>

<%
int x=10;
out.println(x);
%>

<p>这是一个JSP文档</p>
<%
int y=2;
out.println(y);
%>
<hr>

<%--   在代码里嵌入HTML元素 --%>
<%
    for (int i = 0; i < 5; i++) {
%>

<h1>Hello,World<%=i%><h1>
    <%
}
%>
    <hr>
        <%-- --%>
    <%!
      static {
      System.out.println("Loading Servlet");
      }
      private int globalVar=0;
      public void duan(){
          System.out.println("进入了方法duan");
      }


    %>

</body>
</html>
