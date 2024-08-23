<%@ page language="java" import="java.util.*,com.entity.*,com.dao.*" pageEncoding="UTF-8"%>
<%
    request.setCharacterEncoding("utf-8");
    String title=request.getParameter("title");
    String content=request.getParameter("content");
    TopicDAO topicDao  = new TopicDAO();   
    User user=(User)session.getAttribute("loginUser"); 
    int      channelId= Integer.parseInt( request.getParameter("channelId") ); // 取得频道id
   
    
    String msg="";
    if(user!=null) // 判断用户是否已经登录
    {
       Topic topic = new Topic();
	   topic.setTitle(title);
	   topic.setContent(content);
	   topic.setChannelId(channelId);
	   topic.setUserId(user.getUserId());
       topicDao.addTopic(topic);  // 保存主题帖子
       int   n=topicDao.addTopic(topic);
	   if(n==1)
	   {
       response.sendRedirect("topicList.jsp?page=1&channelId="+channelId); // 跳转
       return;
       }
       else
         msg="数据库出错！";
    }
    msg="你还未登录！";
  
    RequestDispatcher dispatcher=request.getRequestDispatcher("error.jsp?msg="+msg);
    dispatcher.forward(request,response);
 %>
