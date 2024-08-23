<%@ page language="java" import="java.util.*,com.entity.*,com.dao.*"
	pageEncoding="UTF-8"%>
<html>
<head>
<title>My JSP 'index.jsp' starting page</title>
<link href="style/style.css" rel="stylesheet" type="text/css">
</head>

<%
      request.setCharacterEncoding("utf-8");
      ChannelDAO   channelDao=new   ChannelDAO();
      TopicDAO   topicDao=new  TopicDAO();
      UserDao     userDao=new   UserDao();
      List   channelList=channelDao.findChanneList();
   %>
<%@ include file="head.jsp"%>
<body>
	<br>
	<br>
	<br>
	<br>
	<div class="t">
		<table width="100%" cellpadding="0" cellspacing="0">
			<tr class="tr3">
				<td colspan="2"></td>
			</tr>
			<tr>
				<%
	               for(int j=0; j<channelList.size(); j++ ) {
                          Channel channel  = (Channel)channelList.get(j);            // 循环取得频道
                          Topic topic =null;             // 最后发表的主题
                          User  channelUser=userDao.findUser(channel.getUserId() );  // 版主
                          User  user =null;           // 最后发表的主题的作者
                          int   channelId   = channel.getChannelId();
                          List  listTopic = topicDao.findListTopic(channelId ); // 取得该板块主题列表
	                      if(listTopic!=null &&listTopic.size()>0 ) {
                               topic = (Topic)listTopic.get(listTopic.size()-1);  // 取得最后发表的帖子
                               user  = userDao.findUser( topic.getUserId() );
            %>
				<!-- 有主题块-->
				<td width="5%" class="h"><img src="image/channel.gif"
					width="27" height="32"></td>
				<th align="left" width="55%" class="h"><h3>
						<a href="topicList.jsp?page=1&amp;channelId=<%=channelId %>"><%=channel.getChannelName()%></a>
					</h3></th>
				<th class="h">
					<table width="400" border="0" bgcolor="#FFFFFF">
						<tr>
							<td width="100" class="gray">最新主题：</td>
							<td class="tr3"><a
								href="replyList.jsp?page=1&amp;channelId=<%=channelId %>&amp;topicId=<%=topic.getTopicId() %>"><%=topic.getTitle() %></a>
								&nbsp;</td>
						</tr>
						<tr>
							<td width="100" class="gray">作&nbsp;&nbsp;&nbsp;&nbsp;者：</td>
							<td class="tr3"><%=user.getUserName()%></td>
						</tr>
						<tr>
							<td width="100" class="gray">发帖时间：</td>
							<td class="tr3"><%=topic.getPublishTime().substring(0,19)%></td>
						</tr>
					</table>
				</th>
			</tr>
			<%}  else{ %>
			<!-- 不带主题的版块-->
			<tr>
				<td width="5%" class="h"><img src="image/channel.gif"
					width="27" height="32"></td>
				<td align="left" class="h"><h3>
						<a href="topicList.jsp">版块名称</a>
					</h3></td>
				<th class="h">&nbsp;</th>
			</tr>
			<%} %>
			<!-- 显示版主姓名和主题数量的行-->
			<tr>
				<td width="5%" class="tr2">&nbsp;</td>
				<th align="left" bgcolor="#CCCCCC" class="tr2"><span
					style="width: 30%;">版主：<%=channelUser.getUserName() %></span></th>
				<td align="center" bgcolor="#CCCCCC" class="tr2">主题数量：<%=topicDao.findCountTopic(channelId) %></td>
			</tr>
			<%
                     }
                %>
		</table>
	</div>
	<br />


</body>
</html>
