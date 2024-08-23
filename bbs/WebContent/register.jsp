<%@ page language="java" contentType="text/html;charset=utf-8" import="java.util.*"%>
<html>
<head><title>学习论坛--注册</title>
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
<form name="form1" action="" method="post" onSubmit="return check()">
<table width="80%" height="193" border="0" align="center">
  <tr>
    <td width="40%" align="right">用&nbsp;户&nbsp;名：</td>
    <td  align="left" >
      <input name="userName" type="text" maxlength="20" size="28"  />
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
        <img src="image/head/head01.jpg" width="30" height="30">
        <input type="radio" name="radio"  value="head01.jpg">
        <img src="image/head/head02.jpg" width="30" height="30">
        <input type="radio" name="radio" value="head02.jpg">
        <img src="image/head/head03.jpg" width="30" height="30">
        <input type="radio" name="radio"  value="head03.jpg">
        <img src="image/head/head04.jpg" width="30" height="30">
        <input type="radio" name="radio"  value="head04.jpg">
         <img src="image/head/head05.jpg" width="30" height="30">
        <input type="radio" name="radio"  value="head05.jpg"><br>
                <img src="image/head/head06.jpg" width="30" height="30">
        <input type="radio" name="radio"  value="head06.jpg">
        <img src="image/head/head07.jpg" width="30" height="30">
        <input type="radio" name="radio" value="head07.jpg">
        <img src="image/head/head08.jpg" width="30" height="30">
        <input type="radio" name="radio"  value="head08.jpg">
        <img src="image/head/head09.jpg" width="30" height="30">
        <input type="radio" name="radio"  value="head09.jpg">
         <img src="image/head/head10.jpg" width="30" height="30">
        <input type="radio" name="radio"  value="head10.jpg"><br>
         <img src="image/head/head11.jpg" width="30" height="30">
        <input type="radio" name="radio"  value="head11.jpg">
        <img src="image/head/head12.jpg" width="30" height="30">
        <input type="radio" name="radio" value="head12.jpg">
        <img src="image/head/head13.jpg" width="30" height="30">
        <input type="radio" name="radio"  value="head13.jpg">
        <img src="image/head/head14.jpg" width="30" height="30">
        <input type="radio" name="radio"  value="head14.jpg">
         <img src="image/head/head15.jpg" width="30" height="30">
        <input type="radio" name="radio"  value="head15.jpg"><br>
          <img src="image/head/head16.jpg" width="30" height="30">
        <input type="radio" name="radio"  value="head16.jpg">
        <img src="image/head/head17.jpg" width="30" height="30">
        <input type="radio" name="radio" value="head17.jpg">
        <img src="image/head/head18.jpg" width="30" height="30">
        <input type="radio" name="radio"  value="head18.jpg">
        <img src="image/head/head19.jpg" width="30" height="30">
        <input type="radio" name="radio"  value="head19.jpg">
         <img src="image/head/head20.jpg" width="30" height="30">
        <input type="radio" name="radio"  value="head20.jpg"><br>
        <img src="image/head/head21.jpg" width="30" height="30">
        <input type="radio" name="radio"  value="head21.jpg">
        <img src="image/head/head22.jpg" width="30" height="30">
        <input type="radio" name="radio" value="head22.jpg">
        <img src="image/head/head23.jpg" width="30" height="30">
        <input type="radio" name="radio"  value="head23.jpg">
        <img src="image/head/head24.jpg" width="30" height="30">
        <input type="radio" name="radio"  value="head24.jpg">
         <img src="image/head/head25.jpg" width="30" height="30">
        <input type="radio" name="radio"  value="head25.jpg"><br><br>
        
     </td>
  </tr>
  <tr>
    <td align="right">&nbsp;</td>
    <td align="left"> 
      <input type="submit" name="Submit" value="注册" />
    &nbsp;&nbsp;&nbsp;&nbsp;
      <input type="reset" name="Submit2" value="重置" />
   </td>
  </tr>
</table>
</form>
</body>
</html>