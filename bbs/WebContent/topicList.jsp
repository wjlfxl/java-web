<%@ page language="java" import="java.util.*,com.entity.*,com.dao.*" pageEncoding="UTF-8"%>
<html>
  <head>
 <title>My JSP 'index.jsp' starting page</title>
	<link rel="stylesheet" type="text/css" href="style/style.css">
  </head><br>

  <% 
       request.setCharacterEncoding("utf-8");
       ChannelDAO channelDao=new ChannelDAO();
       UserDao userDao=new UserDao();
       TopicDAO topicDao=new TopicDAO();
       ReplyDAO replyDao=new ReplyDAO();
       int channelId=Integer.parseInt(request.getParameter("channelId"));
       int  p=Integer.parseInt(request.getParameter("page"));
       Channel channel=channelDao.getChannel(channelId);
       List topicList=topicDao.findListTopic(p,channelId); 
       int  prep=p;
       int  nextp=p;
       if(topicList.size()>=8)  nextp=p+1;
       if(p>1)  prep=p-1;
  %>
  <%@include file="head.jsp" %>
  -<B><a href="topicList.jsp"><%=channel.getChannelName() %></a></B>
  <br><br>
  <body>
     <!--   此处后期添加发帖按钮   -->
     <div>
           <input type="button" class="btn" value="发&nbsp;&nbsp;帖" onClick="window.location.href='tip.jsp?post=newtopic&channelId=<%=channelId %>'">
     </div>
	<br>
     <!--   此处后期添加翻 页功能       -->
   <div>
      
      <a href="topicList.jsp?page=<%=prep %>&amp;channelId=<%=channelId%>">上一页</a>
      <a href="topicList.jsp?page=<%=nextp %>&amp;channelId=<%=channelId%>">下一页</a>
   </div>
   <div class="t">
   <table width="100%" cellspacing="0" cellpadding="0">
  <TR><TH class="h" style="WIDTH: 100%" colSpan="4"><SPAN>&nbsp;</SPAN></TH>
			</TR>
<!--       表 头           -->
			<TR class="tr2">
				<TD>&nbsp;</TD>
				<TD style="WIDTH: 80%" align="center">主题</TD>
				<TD style="WIDTH: 10%" align="center">发表人</TD>
				<TD style="WIDTH: 10%" align="center">回复</TD>
			</TR>

   <!-- 循环显示所有主题-->
   <%
        for(int j=0;j<topicList.size();j++){
          Topic topic=(Topic)topicList.get(j);
           User user=userDao.findUser(topic.getUserId());
    %>
  <TR class="tr3">
		<TD><IMG src="image/channel.gif" border=0></TD>
		<TD ><A href="replyList.jsp?page=1&amp;channelId=<%=channelId %>&topicId=<%=topic.getTopicId()%>"><%=topic.getTitle() %></A></TD>
		<TD align="center"><%=user.getUserName() %></TD>
		<TD align="center"><%=replyDao.findCountReply(topic.getTopicId())%></TD>
	</TR>

   <!-- 循环语句结束-->
   <%
       }
    %>
</table>
  </div>
  <!--   此处后期添加翻 页功能       -->  
  <div>
      
      <a href="topicList.jsp?page=<%=prep %>&amp;channelId=<%=channelId%>">上一页</a>
      <a href="topicList.jsp?page=<%=nextp %>&amp;channelId=<%=channelId%>">下一页</a>
   </div> 
  <br>
  </body>
</html>
