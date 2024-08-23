<%@ page language="java" contentType="text/html;charset=utf-8" import="java.util.*"%>
<html>
<head><title>学习论坛--登录</title>
<script>
function check(){
 if(document.form1.userName.value=="")
 {alert("用户名不能为空");
   return false;}
  if(document.form1.pass1.value=="")
 {alert("密码不能为空");
   return false;}
 if(document.form1.pass1.value.length<6)
 {alert("密码长度不能小于6");
   return false;} 
}
</script>
<link href="style/style.css" rel="stylesheet" type="text/css">
</head>
<%
     //查找名为username的Cookie
     request.setCharacterEncoding("utf-8");
     String userName="";
     Cookie temp=null;
     Cookie[] cookies=request.getCookies();
     if(cookies!=null)
     {
         for(int i=0;i<cookies.length;i++)
         {
           temp=cookies[i];
           if(temp.getName().equals("userName")) 
           {
              userName=temp.getValue();break;
           }
         }
     }
 %>
<body> 
<%@include file="head.jsp" %>
<form name="form1" action="doLogin.jsp" method="post" onSubmit="return check()">
<table width="80%" height="193" border="0" align="center">
  <tr>
    <td width="40%" align="right">用&nbsp;户&nbsp;名：</td>
    <td  align="left" >
      <input name="userName" type="text" maxlength="20" size="28" value=<%=userName %>  />
    </td>
  </tr>
  <tr>
    <td align="right">密&nbsp;&nbsp;&nbsp;&nbsp;码：</td>
    <td align="left"><input name="pass1" type="password" size="30" maxlength="20" /></td>
  </tr>
  <tr>
    <td align="right">&nbsp;</td>
    <td align="left"> 
      <input type="submit" name="Submit" value="登录" />
    &nbsp;&nbsp;&nbsp;&nbsp;
      <input type="reset" name="Submit2" value="重置" />
   </td>
  </tr>
</table>
</form>
</body>
</html>