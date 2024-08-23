<%@ page language="java" import="java.util.*,com.dao.*,com.entity.*" pageEncoding="UTF-8"%>
<%
     request.setCharacterEncoding("utf-8");
     String   I=request.getParameter("I");
     int   userId=Integer.parseInt(request.getParameter("userId"+I));
     int   role=Integer.parseInt(request.getParameter("role"+I));
     UserDao   userDao=  new  UserDao();
     User   loginuser=(User)session.getAttribute("loginUser");
     String   msg="";
     if(loginuser==null||loginuser.getRole()>1)   msg="您无此权限！";
     else   if(loginuser.getUserId()==userId)  msg="不能修改当前用户角色！";
     else  if(userDao.isChannelMaster(userId)&&role==3)   msg="该用户是某个板块的版主，不能直接修改成普通用户！";
     
   
     
 %>