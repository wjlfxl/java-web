<%--
  Created by IntelliJ IDEA.
  User: asus
  Date: 2021/10/24
  Time: 11:21
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>内置对象</title>
</head>
<body>

<%--内置对象--%>
<%
    /*保存值*/
    pageContext.setAttribute("name1x","王炸1");//保存的数据只在一个页面中有效
    request.setAttribute("name2x","王炸2");//保存的数据只在一次请求中有效，请求转发会携带该数据
    session.setAttribute("name3x","王炸3");//保存的数据只在一次会话中有效，从打开浏览器到关闭浏览器
    application.setAttribute("name4x","王炸4");//保存的数据只在服务器中有效，从打开服务器到关闭服务器
%>

<%
  /*方法一：取出值*/
    String name1=(String) pageContext.getAttribute("name1x");
    String name2=(String)request.getAttribute("name2x");
    String name3=(String)session.getAttribute("name3x");
    String name4=(String)application.getAttribute("name4x");
%>
<h3>${name1}</h3>
<h3>${name2}</h3>
<h3>${name3}</h3>
<h3>${name4}</h3>


<%
    /*方法二：findAttribute  从底层找到高层（作用域）*/
    String name11=(String) pageContext.findAttribute("name1x");
    String name12=(String) pageContext.findAttribute("name2x");
    String name13=(String) pageContext.findAttribute("name3x");
    String name14=(String) pageContext.findAttribute("name4x");

%>

<h2>${name11}</h2>
<h2>${name12}</h2>
<h2>${name13}</h2>
<h2>${name14}</h2>


</body>
</html>
