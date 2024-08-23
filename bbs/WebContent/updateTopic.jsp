<%@ page language="java" import="java.util.*,com.entity.*,com.dao.*" pageEncoding="UTF-8"%>
<html>
  <head>
    <title>学习论坛--修改帖子</title>
    <Link  rel="stylesheet" type="text/css" href="style/style.css" />
    <script  type="text/javascript">
    function check(){
	if(document.postForm.title.value=="") {
		alert("标题不能为空");
		return false;
	}
	if(document.postForm.content.value=="") {
		alert("内容不能为空");
		return false;
	}
	if(document.postForm.content.value.length>500) {
		alert("长度不能大于500");
		return false;
	}
}
</script>
</head>
<%
    request.setCharacterEncoding("utf-8");
    User  loginuser=(User)session.getAttribute("loginUser");
    ChannelDAO    channelDao= new ChannelDAO();
    TopicDAO topicDao=new TopicDAO();
    int   channelId= Integer.parseInt( request.getParameter("channelId") );
    int   topicId= Integer.parseInt( request.getParameter("topicId") );
    Topic  topic=topicDao.findTopic(topicId);
    Channel    channel= channelDao.getChannel(channelId );  
    if(loginuser==null||topic.getUserId()!=loginuser.getUserId()){
    RequestDispatcher dispatcher=request.getRequestDispatcher("error.jsp?msg=您无此权限！");
    dispatcher.forward(request,response);
    }
  %> 
 <body>
<%@include file="head.jsp" %>
		<B><a href="index.jsp">论坛首页</a></B> -
		<B><a href="topicList.jsp?page=1&channelId=<%=channelId %>"><%=channel.getChannelName() %></a></B>

	<div>
		<form  name="updateForm" onSubmit="return check();" action="doUpdateTopic.jsp?channelId=<%=channelId %>&topicId=<%=topic.getTopicId()%>" method="post">
			<input type="hidden" name="channelId" value="<%=channelId%>"/>
			<input type="hidden" name="topicId"   value="<%=topicId%>"/>
			<div class="t">
				<table cellSpacing="0" cellPadding="0" align="center">
				<tr><td class="h" colspan="3"><B>&#20462;&#25913;&#24086;&#23376;</B></td></tr>
				<tr class="tr3">
					<th width="20%"><B>标题</B></th>
					<th><input   name="title" value="<%=topic.getTitle()%>" class="input" style="padding-left: 2px; font: 14px Tahoma" tabIndex="1" size="60"></th></tr>
				<tr class="tr3"><th vAlign="top"><div><B>内容</B></div>
					</th>
					<th colSpan="2">
					<div><span><textarea  name="content" style="width: 500px;" rows="20" cols="90" tabIndex="2" ><%=topic.getContent()%>
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
