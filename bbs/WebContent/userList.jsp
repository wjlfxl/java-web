<%@ page language="java" import="java.util.*,com.dao.*,com.entity.*" pageEncoding="UTF-8"%>

<html>
  <head>
    <title>修改用户界面</title>
    <link href="style/style.css" rel="stylesheet" type="text/css">
  </head>
   <%@include  file="head.jsp" %><b>--用户管理</b>
   <%
      request.setCharacterEncoding("utf-8");
      UserDao   userDao=new  UserDao();
      List   userList=userDao.findUser();
      User  loginUser=(User)session.getAttribute("loginUser");
      if(loginUser==null||loginUser.getRole()>1)//判断是否是管理员
      {
      response.sendRedirect("index.jsp");
      return;
      }
    %>
  <body>
     <div  class="t">
		<B><a  href="index.jsp">论坛首页</a></B> -
		<B><a  href="userList.jsp">用户管理</a></B>
	<table  width="100%"   cellpadding="0"   cellspacing="0">
    <tr   class="tr2" align="center">
		<td  colSpan="2">用户列表</td>
		<td  style="WIDTH: 30%;">角色</td>
		<td  style="WIDTH: 25%;">操作</td>
   </tr>
   <tr>
   	   <td  colspan="4"></td>
   </tr>
   <%
     for(int  j=0;j<userList.size();j++){
     User   user=(User)userList.get(j);//当前循环获得一个用户
       
    %>
   <form   name="form1"  action="doUpdateUserRole.jsp?I=<%=j %>"   method="post">
   <input  type="hidden"   name="userId<%=j %>"  value="<%=user.getUserId() %>">
   <tr   class="tr3">
       <td width="5%">&nbsp;</td>
	   <th align="left"> <%if(loginUser.getUserId()==user.getUserId()){ %>
	   <B><%=user.getUserName() %><B>
	   <%}else{ %><%=user.getUserName() %>
	   <%} %>
	   </th>
       <td align="center">
       
       <%if(user.getRole()==3){ %>
       <input name="role<%=j %>" type="radio" value="3"  checked="checked" />普通用户
       <%}else{ %>
       <input name="role<%=j %>" type="radio" value="3" />普通用户
        <%} %>
        
        <%if(user.getRole()==2){ %>
       <input name="role<%=j %>" type="radio" value="2"  checked="checked" />版主
       <%}else{ %>
       <input name="role<%=j %>" type="radio" value="2" />版主
       <%} %>
       
       <%if(user.getRole()==1){ %>
       <input name="role<%=j %>" type="radio" value="1"  checked="checked" />管理员
       <%}else{ %>
       <input name="role<%=j %>" type="radio" value="1" />管理员
       <%} %>
       </td>
   <th>
   <input name="" type="submit" value="修&nbsp;&nbsp;改" />&nbsp;
   <input name="" type="button" onclick="" value="删&nbsp;&nbsp;除" />
   </th>
   </tr>
   </form>
   <%} %>
   </table>
   </div><br>

          
  </body>
</html>
