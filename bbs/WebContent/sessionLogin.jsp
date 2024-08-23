<%@ page contentType="text/html;charset=gb2312"%>
<script language="javascript">
 function on_submit()
 {//验证数据的合法性
  if (form1.username.value == "")
			 {
			  alert("用户名不能为空，请输入用户名！");
			  form1.username.focus();
			  return false;
			 }
    if (form1.userpassword.value == "")
			 {
			  alert("用户密码不能为空，请输入密码！");
			  form1.userpassword.focus();
			  return false;
			 }
 }
</script>
<html>
	<head>
		<title>用户登录</title>
	</head>
	<body>
		<table aligin="center">
			<form name="form1" method="post" action="sessionSet.jsp"
				onSubmit="return on_submit()">
			<tr aligin="center">
				<td>
					用户登录
				</td>
			</tr>
			<tr aligin="center">
				<td>
					请输入用户名：
					<input type="text" name="username" size="20">
				</td>
			</tr>
			<tr aligin="center">
				<td>
					请输入密码：&nbsp;&nbsp;
					<input type="password" name="userpassword" size="20">
				</td>
			</tr>
			<tr aligin="center">
				<td>
					<input type="submit" value="提交" name="B1">
					<input type="reset" value="全部重写" name="B2">
				</td>
			</tr>
			</form>
		</table>
	</body>
</html>
