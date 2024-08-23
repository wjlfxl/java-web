<%@ page language="java" import="java.util.*,com.entity.*,com.dao.*" pageEncoding="utf-8"%>
<html>
  <head>
    <title>学习论坛--发布帖子</title>
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
    if(session.getAttribute("loginUser")==null){
	request.getRequestDispatcher("error.jsp?msg=您尚未登录!").forward(request,response);
	return;
    }
    
     ChannelDAO    channelDao= new ChannelDAO();
    UserDao userDao=new UserDao();
    TopicDAO topicDao=new TopicDAO();
    ReplyDAO replyDao=new ReplyDAO();
    int   channelId= Integer.parseInt( request.getParameter("channelId") );
    String   topicId=request.getParameter("topicId")==null?"":request.getParameter("topicId");
    Channel    channel= channelDao.getChannel(channelId );  
    //Topic   topic=topicDao.findTopic(topicId);
    Topic   topic=null;
    if(topicId!="")
      topic=topicDao.findTopic(Integer.parseInt(topicId));
   // String   topicId= request.getParameter("topicId")==null ? "": request.getParameter("topicId");
    //String   formAction = request.getParameter("post").equals("newreply")? "doAddReply.jsp":"doAddTopic.jsp";
    String    post=request.getParameter("post");
    String   formAction =post.equals("newreply")?"doAddReply.jsp":"doAddTopic.jsp"; 
  %> 
  <body>
    <%@include file="head.jsp" %>
   —<B><a href="topicList.jsp?page=1&amp;channelId=<%=channelId %>"><%=channel.getChannelName() %></a></B>
        <%if(topic!=null){ %>
      —<B><a href="replyList.jsp?page=1&amp;channelId=<%=channelId %>&topicId=<%=topicId%>"><%=topic.getTitle() %></a></B>
        <%} %>
  
        <div>
         <form   name="postForm" onSubmit="return check()" action="<%=formAction%>" method="POST">
              <input  type="hidden" name="channelId" value="<%=channelId%>"/>
              <input  type="hidden" name="topicId" value="<%=topicId%>"/>
              <div   class="t">
                  <table cellSpacing="0" cellPadding="0" align="center" >
                      <tr><td  class="h" colSpan="3"><B>发布帖子</B></td></tr>
                      <tr class="tr3">
                          <th width="20%"><B>标题</B></th>
                          <th><input class="input" style="padding-left: 2px; font: 14px Tahoma" tabIndex="1" size="60" name="title"></th>
                      </tr>
                      <tr class="tr3">
                          <th valign=top><div><B>内容</B></div></th>
				          <th colSpan=2>
				          <div><span><textarea style="width: 500px;" name="content" rows="20" cols="90" tabIndex="2" ></textarea></span></div>
                                    (不能大于:<font color="blue">500</font>字)
				          </th>
	                  </tr>
               </table>
          </div>		
          <div style="margin: 15px 0px; text-align: center">
          <input class="btn" tabIndex="3" type="submit" value="提 交">
          <input class="btn" tabIndex="4" type="reset"  value="重 置">
          </div>
		</form>	
	</div>
   </div>
   <!--      声明        -->
   <br/>
   <center class="gray">JSP学习论坛2019</center>

   
  </body>
</html>
