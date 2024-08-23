<%@ page language="java" import="java.util.*,com.entity.*,com.dao.*" pageEncoding="UTF-8"%>
<%
request.setCharacterEncoding("utf-8");
ReplyDAO replyDao  = new ReplyDAO();// 得到回复Dao的实例
int   channelId= Integer.parseInt( request.getParameter("channelId") );
int      replyId   = Integer.parseInt( request.getParameter("replyId") ); // 取得回复id
int   topicId = Integer.parseInt( request.getParameter("topicId"));//取得主题id
String   title= request.getParameter("title");    // 取得帖子标题
String   content= request.getParameter("content");  // 取得帖子内容
User  user = (User)session.getAttribute("loginUser");// 从session中取得登录用户
String   msg= "";
Reply reply=replyDao.findReply(replyId);
if( user!=null && reply!=null && user.getUserId()==reply.getUserId()) {   // 用户自己发布的主题只能自己修改                                               // 判断用户是否已经登录
	reply.setTitle(title);  
	reply.setContent(content);
	replyDao.updateReply(reply);
	response.sendRedirect("replyList.jsp?page=1&channelId="+channelId+"&topicId="+topicId);    // 跳转
	return;
} else {
	msg = "您无此权限";
}
String forward="/error.jsp?msg="+msg;
request.getRequestDispatcher(forward).forward(request,response);
%>
