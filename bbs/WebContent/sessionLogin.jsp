<%@ page contentType="text/html;charset=gb2312"%>
<script language="javascript">
 function on_submit()
 {//��֤���ݵĺϷ���
  if (form1.username.value == "")
			 {
			  alert("�û�������Ϊ�գ��������û�����");
			  form1.username.focus();
			  return false;
			 }
    if (form1.userpassword.value == "")
			 {
			  alert("�û����벻��Ϊ�գ����������룡");
			  form1.userpassword.focus();
			  return false;
			 }
 }
</script>
<html>
	<head>
		<title>�û���¼</title>
	</head>
	<body>
		<table aligin="center">
			<form name="form1" method="post" action="sessionSet.jsp"
				onSubmit="return on_submit()">
			<tr aligin="center">
				<td>
					�û���¼
				</td>
			</tr>
			<tr aligin="center">
				<td>
					�������û�����
					<input type="text" name="username" size="20">
				</td>
			</tr>
			<tr aligin="center">
				<td>
					���������룺&nbsp;&nbsp;
					<input type="password" name="userpassword" size="20">
				</td>
			</tr>
			<tr aligin="center">
				<td>
					<input type="submit" value="�ύ" name="B1">
					<input type="reset" value="ȫ����д" name="B2">
				</td>
			</tr>
			</form>
		</table>
	</body>
</html>
