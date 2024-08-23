<%@ page language="java" import="java.util.*,com.entity.*,com.dao.*" pageEncoding="UTF-8"%>
<%
    request.setCharacterEncoding("utf-8");
    String title=request.getParameter("title");
    String content=request.getParameter("content");
    ReplyDAO replyDao  = new ReplyDAO();  
    User user=(User)session.getAttribute("loginUser"); 
    int      channelId= Integer.parseInt( request.getParameter("channelId") ); // 取得频道id
    int      topicId= Integer.parseInt( request.getParameter("topicId") ); 
    
    String msg="";
    if(user!=null) 
    {
       Reply reply = new Reply();
	   reply.setTitle(title);
	   reply.setContent(content);
	   reply.setTopicId(topicId);
	   reply.setUserId(user.getUserId());
	   int   n=replyDao.addReply(reply);
	   if(n==1)
	   {
       response.sendRedirect("replyList.jsp?page=1&channelId="+channelId+"&topicId="+topicId); // 跳转
       return;
       }
       else
         msg="数据库出错！";
    }
    msg="你还未登录！";
    RequestDispatcher dispatcher=request.getRequestDispatcher("error.jsp?msg="+msg);
    dispatcher.forward(request,response);
 %>
