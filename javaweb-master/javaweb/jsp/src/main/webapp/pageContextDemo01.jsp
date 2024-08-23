<%--
  Created by IntelliJ IDEA.
  User: zhongwuduan
  Date: 2022/2/13
  Time: 18:16
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<%
    pageContext.setAttribute("name1","wudaun1");//保存的数据仅在一个页面有效
    request.setAttribute("name2","wudaun2");//保存的数据只在一次请求中有效，请求转发可以携带这个数据
    session.setAttribute("name3","wudaun3");//保存的数据只在一次会话中有效，从打开浏览器到关闭浏览器
    application.setAttribute("name4","wuduan4");//保存的数据只在服务器中有效，从打开服务器到关闭服务器

%>
<%--
脚本片段里的代码，会被原封不动地生成到  **.jsp.java
要求：这里面的代码必须要争java语法的正确性
--%>
<%
    //从pageContext中取出，我们通过寻找的方式来实现
    //从底层到该高层（作用域）:page->request->session->application，即从小范围到大范围
    //JVM:双亲委派机制
    String name1 = (String)pageContext.findAttribute("name1");
    String name2 = (String)pageContext.findAttribute("name2");
    String name3 = (String)pageContext.findAttribute("name3");
    String name4 = (String)pageContext.findAttribute("name4");
    String name5 = (String)pageContext.findAttribute("name5");

pageContext.forward("/pageDemo02.jsp");
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
