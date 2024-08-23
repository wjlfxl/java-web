<%@ page language="java" contentType="text/html;charset=utf-8" import="java.util.*"%>
<html>
<head><title>学习论坛--修改</title>
<script>
function check(){
 if(document.form1.userName.value=="")
 {alert("用户名不能为空");
   return false;}
  if(document.form1.pass1.value=="")
 {alert("密码不能为空");
   return false;}
   if(document.form1.pass1.value!=document.form1.pass2.value)
 {alert("两次密码不一样");
   return false;}
     if(document.form1.pass1.value.length<6)
 {alert("密码长度不能小于6");
   return false;} 
}
</script>
<link href="style/style.css" rel="stylesheet" type="text/css">
</head>
<body>
<%@include file="head.jsp" %>
<%
    User loginUser=(User)session.getAttribute("loginUser");
   // int n=Integer.parseInt(loginUser.getHead().substring(4,2));
 %>
<form name="form1" action="doUpdateUser.jsp" method="post" onSubmit="return check()">
<table width="80%" height="193" border="0" align="center">
  <tr>
    <td width="40%" align="right">用&nbsp;户&nbsp;名：</td>
    <td  align="left" >
      <input name="userName" type="text" maxlength="20" size="28" value=<%=loginUser.getUserName()%>/>
    </td>
  </tr>
  <tr>
    <td align="right">密&nbsp;&nbsp;&nbsp;&nbsp;码：</td>
    <td align="left"><input name="pass1" type="password" size="30" maxlength="20" /></td>
  </tr>
 <tr>
    <td align="right">重复密码：</td>
    <td align="left"><input name="pass2" type="password" size="30" maxlength="20"/></td>
  </tr>
 <tr>
    <td align="right">角&nbsp;&nbsp;&nbsp;&nbsp;色：</td>
    <td align="left">
       普通用户
    </td>
  </tr>
  <tr>
  <td align="right">选择头像：</td>
    <td align="left">
<%
    for(int i=1;i<=25;i++)
    {
      //显示头像图片
     out.println("<img src='image/head_old/head"+i+".jpg' width='30' height='30'>");
      //显示单选按钮
     // if()
     out.println("<input type='radio' name='radio'  value='head"+i+".jpg'>");
      if(i%5==0) out.println("<br>");
    }

%>
        
     </td>
  </tr>
  <tr>
    <td align="right">&nbsp;</td>
    <td align="left"> 
      <input type="submit" name="Submit" value="修改" />
    &nbsp;&nbsp;&nbsp;&nbsp;
      <input type="reset" name="Submit2" value="重置" />
   </td>
  </tr>
</table>
</form>
</body>
</html>