<%@ page language="java" import="java.util.*,com.entity.*,com.dao.*" pageEncoding="UTF-8"%>
<%
    request.setCharacterEncoding("utf-8");
    String userName=request.getParameter("userName");
    String password=request.getParameter("pass1");
    String head=request.getParameter("head");
    User user=null;
    UserDao   userDao=new   UserDao();
    String msg="";
    if(user!=null&&password!=null)
    {
      if(userDao.findUser(userName)!=null)  {msg="该用户已存在！";}
     else{
          user=new    User();
          user.setHead(head);
          user.setPassword(password);
          user.setUserName(userName);
          int num=userDao.addUser(user);
          if(num==1){response.sendRedirect("login.jsp");return;}
         else if(num==0)   {msg="注册失败！数据库错误！";}
     }
   }
    //假设名字重复，转到错误页面，提示错误信息“该用户已存在”
    // RequestDispatcher   forword()
    RequestDispatcher dispatcher=request.getRequestDispatcher("error.jsp?msg="+msg);
    dispatcher.forward(request,response);
 %>
