<%@ page language="java" import="java.util.*,com.entity.*,com.dao.*" pageEncoding="UTF-8"%>
<html>
  <head>
    <title>学习论坛--回复帖子</title>
    <Link  rel="stylesheet" type="text/css" href="style/style.css" />
    
</head>
<%
    request.setCharacterEncoding("utf-8");
    ChannelDAO   channelDao = new ChannelDAO();    // 得到频道Dao的实例
    ReplyDAO     replyDao=new ReplyDAO();            // 得到回复Dao的实例
    int   channelId  = Integer.parseInt( request.getParameter("channelId") );// 取得频道id
    int   replyId = Integer.parseInt( request.getParameter("replyId") );  // 取得回复id
    int    topicId = Integer.parseInt( request.getParameter("topicId") );  // 取得主题id
    Channel  channel  = channelDao.getChannel( channelId ); // 取得频道信息
    User     user  = (User)session.getAttribute("loginUser");// 从session中取得登录用户
    Reply    reply = replyDao.findReply(replyId);   
    if( user==null || user.getUserId()!=reply.getUserId()) {  // 判断用户权限 
        String msg = "您无此权限";
        String forward="/error.jsp?msg="+msg;
        request.getRequestDispatcher(forward).forward(request,response);
        return;
}                         // 取得回复信息
%>


  %> 
 <body>
<%@include file="head.jsp" %>
		<B><a href="index.jsp">论坛首页</a></B> -
		<B><a href="topicList.jsp?page=1&channelId=<%=channelId %>"><%=channel.getChannelName() %></a></B>

	<div>
		<form  name="updateForm" onSubmit="return check();" action="doUpdateReply.jsp?channelId=<%=channelId %>&replyId=<%=reply.getReplyId()%>&topicId=<%=topicId %>" method="post">
			<input type="hidden" name="channelId" value="<%=channelId%>"/>
			<input type="hidden" name="topicId"   value="<%=topicId%>"/>
			<div class="t">
				<table cellSpacing="0" cellPadding="0" align="center">
				<tr><td class="h" colspan="3"><B>&#20462;&#25913;&#24086;&#23376;</B></td></tr>
				<tr class="tr3">
					<th width="20%"><B>标题</B></th>
					<th><input   name="title" value="<%=reply.getTitle()%>" class="input" style="padding-left: 2px; font: 14px Tahoma" tabIndex="1" size="60"></th></tr>
				<tr class="tr3"><th vAlign="top"><div><B>内容</B></div>
					</th>
					<th colSpan="2">
					<div><span><textarea  name="content" style="width: 500px;" rows="20" cols="90" tabIndex="2" ><%=reply.getContent()%>
</textarea></span>
						</div>
					      (不能大于:<font color="blue">500</font>字)
					</th>
					</tr>
				</table>
			</div>
			<div  style="margin: 15px 0px; text-align: center">
				<input class="btn" tabIndex="3" type="submit" value="修 改">
			</div>
		</from>
	</div>
	<!--      声明        -->
	<br/>
</div>
<center class="gray">JSP学习论坛2009</center>
</body>
</html>
