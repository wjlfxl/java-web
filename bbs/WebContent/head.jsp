<%@ page language="java" import="java.util.*,com.entity.*"
	contentType="text/html;charset=utf-8" pageEncoding="UTF-8"%>
<center>
	<h1>学习论坛</h1>
</center>
<br>
<DIV class="h">
	<%
     if(session.getAttribute("loginUser")==null){
 %>

	您尚未&nbsp;&nbsp;&nbsp;<a href="login.jsp">登陆&nbsp;&nbsp;</a>|&nbsp;&nbsp;<a
		href="register_new.jsp">注册</a> &nbsp;&nbsp;&nbsp;
	<%}
    else {  User loginUser=(User)session.getAttribute("loginUser");
    %>
	您好：<%=loginUser.getUserName() %>
	[<%=loginUser.getRole()==3?"普通用户":loginUser.getRole()==2?"版主":"管理员" %>]
	<a href="updateUser.jsp">修改信息</a>&nbsp;&nbsp;|&nbsp;&nbsp; <a
		href="doLogout.jsp">登出</a>
	<% if(loginUser.getRole()==1) { %>
	&nbsp;|&nbsp; <a href="userList.jsp">用户管理</a>&nbsp;&nbsp;|&nbsp;&nbsp;
	<a href="channelList.jsp">频道管理</a>
	<% }} %>
	<%
    Date d=new Date();// SimpleDateFormat 
    int y=d.getYear()+1900;
    int m=d.getMonth()+1;
    int dy=d.getDate();
    int w=d.getDay(); 
   char[] day={'日','一','二','三','四','五','六'};
    out.println(y+"年"+m+"月"+dy+"日，星期"+day[w]);
   int h=d.getHours();
  if(h<12) out.println("  上午好！");
  else if(h<18) out.println("  下午好！");
       else out.println("  晚上好！");
%>
	<%
  Integer userCount=(Integer)application.getAttribute("userCount");
 %>
	在线人数：<%=userCount %>
</div>
<b><a href="index.jsp">论坛首页</a></b>
