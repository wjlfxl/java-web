<%@page contentType="text/html;charset=gb2312"%>
<html>
	<head>
		<title>sessionת��ҳ��1</title>
	</head>
	<body>
		<%
			String usr = (String) session.getValue("username");
		%>

		<%
			out.println("session����ʱ��Ϊ:" + session.getCreationTime());
		%><br>
		<%
			out.println("session IDΪ:" + session.getId());
		%><br>
		<%
			out.println("session ������ʱ��Ϊ:" + session.getLastAccessedTime());
		%><br>
		<%
			out.println("session ԭ���������ʱ��:" + session.getMaxInactiveInterval());
		%><br>
		<%
			session
					.setMaxInactiveInterval(session.getMaxInactiveInterval() + 1);
			out.println("session �����������ʱ��:" + session.getMaxInactiveInterval());
		%><br>

		�����������sessin������ֵ��
		<br>
		<%
			String[] name = session.getValueNames();
			out.println("--------------" + "<br>");
		%>

		����<%=name.length%>�����ԣ����ǵ�ֵ�ֱ��ǣ�
		<br>
		<%
			for (int i = 0; i < name.length; i++) {
				out.print(name[i]+"   ");
				out.println(session.getValue(name[i]) + "<br>");
			}
			session.removeValue("username");
		%>
	</body>
</html>
