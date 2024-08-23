<%@ page language="java" import="java.util.*,com.entity.*,com.dao.*" pageEncoding="UTF-8"%>


<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <title>学习论坛--看帖</title>
    <meta http-equiv=Content-Type content="text/html; charset=gbk">
    <link rel="stylesheet" type="text/css" href="style/style.css" />
    
  </head>
  <%
    request.setCharacterEncoding("utf-8");
    TopicDAO      topicDao  = new TopicDAO();// 得到主题Dao的实例
    ReplyDAO      replyDao  = new ReplyDAO();     // 得到回复Dao的实例
    ChannelDAO    channelDao  = new ChannelDAO();// 得到频道Dao的实例
    UserDao      userDao= new UserDao();   // 得到用户Dao的实例
    int        channelId= Integer.parseInt( request.getParameter("channelId") ); // 取得频道id
    int        topicId= Integer.parseInt( request.getParameter("topicId") );  // 取得主题id
    int      p = Integer.parseInt(request.getParameter("page"));
    Channel channel=channelDao.getChannel(channelId);
    Topic topic=topicDao.findTopic(topicId);//主题
    User topicUser=userDao.findUser(topic.getUserId());//主题作者
    List replyList=replyDao.findListReply(p, topicId);

    int     prep= p;    
    int     nextp= p;    
    if(p>1) prep=p-1;
    if(replyList.size()>=3) nextp=p+1;
  %>
  
   <%@include file="head.jsp" %>
  -<B><a href="topicList.jsp?page=1&amp;channelId=<%=channelId %>"><%=channel.getChannelName() %></a></B>
  -<B><a href="replyList.jsp?page=1&amp;channelId=<%=channelId %>&topicId=<%=topicId %>"><%=topic.getTitle() %></a></B>
  <br><br>
  <body>
     <!--   此处后期添加发帖按钮   -->
     <div>
     <input type="button" class="btn" value="发&nbsp;&nbsp;帖" onClick="window.location.href='tip.jsp?post=newtopic&channelId=<%=channelId %>'">
     <input type="button" class="btn" value="回&nbsp;&nbsp;复" onClick="window.location.href='tip.jsp?post=newreply&channelId=<%=channelId %>&topicId=<%=topicId %>'">
     </div>
	<br>
     <!--   此处后期添加翻 页功能       -->
	<DIV>
		<a href="replyList.jsp?page=<%=prep%>&channelId=<%=channelId %>&topicId=<%=topicId %>">上一页</a>|
		<a href="replyList.jsp?page=<%=nextp%>&channelId=<%=channelId %>&topicId=<%=topicId %>">下一页</a>
	</DIV>
  <br>
   <!--      本页主题的标题        -->
	<DIV>
		<TABLE cellSpacing="0" cellPadding="0" width="100%">
			<TR>
				<TH class="h">本页主题: <%=topic.getTitle() %></TH>
			</TR>
			<TR class="tr2">
				<TD>&nbsp;</TD>
			</TR>
		</TABLE>
	</DIV>
   <!--主题信息        -->
	<DIV class="t">
	<TABLE style="BORDER-TOP-WIDTH: 0px; TABLE-LAYOUT: fixed" cellSpacing="0" cellPadding="0" width="100%">
	<TR class="tr1">
			<TH style="WIDTH: 20%">
				<img src="image/head/<%=topicUser.getHead()%>"/><BR/><br>
					<B><%=topicUser.getUserName() %></B>
					[<%=topicUser.getRole()==3?"普通用户":topicUser.getRole()==2?"版主":"管理员" %>]<br><br>
					注册时间: <%=topicUser.getRegisterTime().substring(0,19)  %>
			</TH>
		    <TH><DIV class="tipad gray">
				<TABLE  cellpadding="0"  cellspacing="0" width="100%" border="0">
				<tr>
				<th>发表于: <%=topic.getPublishTime().substring(0,19) %> &nbsp;
						修改于: <%=topic.getModifyTime().substring(0,19) %>
						<A href="javascript:confirmDelete()">删除</A>
						<A href="updateTopic.jsp?channelId=<%=channelId %>&topicId=<%=topicId %>">修改</A>
					</th>
					<th width="10%"><div align="right"><b>楼主</b></div></th>
					</tr>
					</TABLE>
					</DIV>
					<H4><%=topic.getTitle() %></H4>
					<DIV><pre><%=topic.getContent() %> </pre></DIV>
					<div class="tipad2">回复次数:<%=replyDao.findCountReply(topic.getTopicId() ) %></div>
				</TH>
			</TR>
		</TABLE>
	</DIV>
   <!--所有回复列表        -->
	<%
	  for(int i=0;i<replyList.size();i++){
       // 循环取得回复信息
       Reply reply=(Reply)replyList.get(i);
       // 取得回复的作者
       User replyUser=userDao.findUser(reply.getUserId());
	%>
	<DIV class="t">
		<TABLE style="BORDER-TOP-WIDTH: 0px; TABLE-LAYOUT: fixed" cellSpacing="0" cellPadding="0" width="100%">
			<TR class="tr1">
				<TH style="WIDTH: 20%">
				<img src="image/head/<%=replyUser.getHead()%>"/><BR/><br>
					<B><%=replyUser.getUserName() %></B>
					[<%=replyUser.getRole()==3?"普通用户":replyUser.getRole()==2?"版主":"管理员" %>]<br><br>
					注册时间:<%=topicUser.getRegisterTime().substring(0,19) %>
				</TH>
				<TH>
				<DIV class="tipad gray">
				<TABLE  cellpadding="0"  cellspacing="0" width="100%" border="0">
				<tr>
				<th>
						回复于:<%=reply.getPublishTime().substring(0,19) %>&nbsp;
						修改于:<%=reply.getModifyTime().substring(0,19) %>
						<A href="servlet/DeleteReplyServlet?channelId=<%=channelId%>&replyId=<%=reply.getReplyId()%>&topicId=<%=topicId%>">删除</A>
						<A href="updateReply.jsp?channelId=<%=channelId%>&replyId=<%=reply.getReplyId()%>&topicId=<%=topicId%>">修改</A>
						</th>
						<th width="10%">
						<div align="right">#<%=(p-1)*3+i+1%>楼</div>
						</th>
						</tr>
						</TABLE>
					</DIV>
					<H4><%=reply.getTitle() %></H4>
					<DIV><pre><%=reply.getContent() %></pre></DIV>
				</TH>
			</TR>
		</TABLE>
	</DIV>
	<% } %>
   
   
   
    
  <!--   此处后期添加翻 页功能       -->  
  <br> 
  <DIV>
		<a href="replyList.jsp?page=<%=prep%>&channelId=<%=channelId %>&topicId=<%=topicId %>">上一页</a>|
		<a href="replyList.jsp?page=<%=nextp%>&channelId=<%=channelId %>&topicId=<%=topicId %>">下一页</a>
	</DIV>
  <br>
  </body>
</html>
