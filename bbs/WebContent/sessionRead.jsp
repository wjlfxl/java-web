<%@page contentType="text/html;charset=gb2312"%>
<html>
	<head>
		<title>session转向页面1</title>
	</head>
	<body>
		<%
			String usr = (String) session.getValue("username");
		%>

		<%
			out.println("session创建时间为:" + session.getCreationTime());
		%><br>
		<%
			out.println("session ID为:" + session.getId());
		%><br>
		<%
			out.println("session 最后访问时间为:" + session.getLastAccessedTime());
		%><br>
		<%
			out.println("session 原来最大休眠时间:" + session.getMaxInactiveInterval());
		%><br>
		<%
			session
					.setMaxInactiveInterval(session.getMaxInactiveInterval() + 1);
			out.println("session 最新最大休眠时间:" + session.getMaxInactiveInterval());
		%><br>

		下面依次输出sessin变量的值：
		<br>
		<%
			String[] name = session.getValueNames();
			out.println("--------------" + "<br>");
		%>

		共有<%=name.length%>个属性，他们的值分别是：
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
