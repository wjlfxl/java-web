<%@ page contentType="text/html;charset=gb2312"%>
<%
	String username1 = request.getParameter("username");
	String userpassword = request.getParameter("userpassword");
	if (username1 != null & userpassword != null) {//����û��������붼�Ϸ��������û�����һ����û�������������ݿ��У�
		//�����ݿ��е���Ϣ���ύ���û���������Ƚ��Խ����û��Ϸ��Լ�飬
		//��Щ�����ں����½��л����ѧϰ
		session.setAttribute("username", username1);
		response.sendRedirect("sessionRead.jsp");
	}
%>