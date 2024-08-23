<%@ page language="java" import="java.util.*,com.entity.*,com.dao.*" pageEncoding="UTF-8"%>
<%
request.setCharacterEncoding("utf-8");
TopicDAO topicDao= new TopicDAO();
int   channelId= Integer.parseInt( request.getParameter("channelId") );
int   topicId= Integer.parseInt( request.getParameter("topicId") );    
String   title     = request.getParameter("title"); // 取得帖子标题
String   content   = request.getParameter("content");  // 取得帖子内容
User   user= (User)session.getAttribute("loginUser");//取得登录用户
String   msg= "";
Topic    topic= topicDao.findTopic(topicId);
if( user!=null && topic!=null && user.getUserId()==topic.getUserId()) {     // 用户自己发布的主题只能自己修改                                               // 判断用户是否已经登录
	topic.setTitle(title);
	topic.setContent(content);
	// 修改时间由Dao类生成
	topicDao.updateTopic(topic);                                                               // 修改主题
	response.sendRedirect("replyList.jsp?page=1&channelId="+channelId+"&topicId="+topicId);    // 跳转
	return;
} else {
	msg = "您无此权限";
}
 RequestDispatcher dispatcher=request.getRequestDispatcher("error.jsp?msg="+msg);
 dispatcher.forward(request,response);
%>
