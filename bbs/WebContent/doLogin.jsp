<%@ page language="java" import="java.util.*,com.entity.*,com.dao.*" pageEncoding="UTF-8"%>
<%
    request.setCharacterEncoding("utf-8");
    String userName=request.getParameter("userName");
    String password=request.getParameter("pass1");
    UserDao   userDao=new  UserDao();
    User user=(User)session.getAttribute("loginUser"); 
    String msg="";
    if(user==null) 
    {
       user=userDao.findUser(userName);
     /* user.setUserName(userName);
       user.setPassword(password);
       user.setHead("head08.jpg");
       user.setRole(1);*/
       if(user!=null&&user.getPassword().equals(password))
       {
       session.setAttribute("loginUser", user);
       Integer userCount=(Integer)application.getAttribute("userCount");
       if(userCount==null)
       {
         application.setAttribute("userCount",new Integer(1));
       }
       else
       {
         application.setAttribute("userCount",new Integer(userCount.intValue()+1));
       }
     //创建Cookie对象
      Cookie cookie=new Cookie("userName",userName);
      cookie.setMaxAge(180);
      response.addCookie(cookie);
      response.sendRedirect("index.jsp");
      return;
    }
    else{  msg="用户名或密码错误";}
    }
   else 
   {
      msg="重复登录！";
   }
    //假设名字重复，转到错误页面，提示错误信息“该用户已存在”
    // RequestDispatcher   forword()
    RequestDispatcher dispatcher=request.getRequestDispatcher("error.jsp?msg="+msg);
    dispatcher.forward(request,response);
 %>
