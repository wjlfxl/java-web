<%@ page contentType="text/html;charset=gb2312"%>
<%
	String username1 = request.getParameter("username");
	String userpassword = request.getParameter("userpassword");
	if (username1 != null & userpassword != null) {//如果用户名和密码都合法，记下用户名，一般把用户和密码存在数据库中，
		//用数据库中的信息与提交的用户名和密码比较以进行用户合法性检查，
		//这些内容在后续章节中会继续学习
		session.setAttribute("username", username1);
		response.sendRedirect("sessionRead.jsp");
	}
%>