package com.zhong.wu.servlet;

import com.zhong.wu.pojo.Person;

import javax.servlet.ServletException;
import javax.servlet.http.*;
import java.io.IOException;

/**
 * @author wuduan
 * @version 1.8
 * @date 2022/1/26 21:57
 */
public class SessionDemo01 extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //解决乱码
        req.setCharacterEncoding("utf-8");
        resp.setCharacterEncoding("utf-8");
        resp.setContentType("text/html;charset=UTF-8");
        //得到Session
        HttpSession session = req.getSession();

        //给Session中存东西
        session.setAttribute("name",new Person("吾褍",19));

        //获取Session的ID
        String id = session.getId();

        //判断Session是否是新创建的
        if(session.isNew()){
            resp.getWriter().write("session创建成功，ID："+id);
        }else{
            resp.getWriter().write("session已经在服务器存在，ID："+id);
        }

        //Session创建的时候做了什么
        //Cookie jsessionid = new Cookie("JSESSIONID", id);
       // resp.addCookie(jsessionid);

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doPost(req, resp);
    }
}
