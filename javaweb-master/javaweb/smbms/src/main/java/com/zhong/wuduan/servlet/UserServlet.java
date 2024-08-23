package com.zhong.wuduan.servlet;

import com.alibaba.fastjson.JSONArray;
import com.mysql.jdbc.StringUtils;
import com.zhong.wuduan.pojo.Role;
import com.zhong.wuduan.pojo.User;
import com.zhong.wuduan.service.UserServiceImpl;
import com.zhong.wuduan.service.role.RoleServiceImpl;
import com.zhong.wuduan.util.Constants;
import com.zhong.wuduan.util.PageSupport;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;

/**
 * @author wuduan
 * @version 1.8
 * @date 2022/2/22 23:30
 */
//实现Servlet复用
public class UserServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String method = req.getParameter("method");
        Object attribute = req.getSession().getAttribute(Constants.USER_SESSION);
        User user = (User) attribute;
        System.out.println(user.getUserPassword());
        if(method.equals("savepwd")&&method!=null){
            this.updatePwd(req,resp);
        }
        if(method.equals("pwdmodify")&&method!=null){
        this.pwdModify(req, resp);
        }
        if(method.equals("query")&&method!=null){
            this.query(req, resp);
        }
        if(method.equals("add")){
            this.add(req, resp);
        }
        if(method.equals("getrolelist")){
            this.getRoleList(req, resp);
            System.out.println("getrolelist");
        }
        if(method.equals("deluser")){
            this.deluser(req, resp);
        }
    }
    /**
     * 删除用户
     */
    public void deluser(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        String userIdStr = req.getParameter("uid");
        HashMap<String, String> resMap = new HashMap<String, String>();
        int userId = 0;

        if (StringUtils.isNullOrEmpty(userIdStr))
            resMap.put("delResult", "false");
        else {
            // 把用户 id 字符串解析为数字，遇到异常则直接放回删除失败
            try {
                userId = Integer.parseInt(userIdStr);
                if (userId < 0) userId = 0;
            } catch (Exception e) {
                e.printStackTrace();
                userId = 0;
            }

            // userId 小于等于零一律为不存在
            if (userId <= 0) resMap.put("delResult", "noexist");
            else {  // userId 正常，开始尝试调用 service 层进行删除
                UserServiceImpl userService = new UserServiceImpl();
                boolean isDeleted = userService.delete(Integer.valueOf(userId));

                if (isDeleted) resMap.put("delResult", "true");
                else resMap.put("delResult", "false");
            }
        }

        // 将 HashMap 对象转为 json 格式返回给前端
        resp.setContentType("application/json");
        PrintWriter writer = resp.getWriter();
        writer.write(JSONArray.toJSONString(resMap));
        writer.flush();
        writer.close();
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    doGet(req,resp);
    }
    /**
     * 获取用户角色列表
     */
    public void getRoleList(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        // 调用用户的业务层，获取用户列表
        RoleServiceImpl roleService = new RoleServiceImpl();
        // 调用用户角色的业务层，获取用户角色列表
        List<Role> userRoleList = null;
        userRoleList = roleService.getUserRoleList();

        // 把用户角色列表转成 json 格式返回给前端
        resp.setContentType("application/json");
        PrintWriter writer = resp.getWriter();
        writer.write(JSONArray.toJSONString(userRoleList));
        writer.flush();
        writer.close();
    }

    /**
     * 添加新用户
     */
    public void add(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
        // 获取前端数据
        System.out.println("===========user add===========");
        String userCode = req.getParameter("userCode");
        String userName = req.getParameter("userName");
        String userPassword = req.getParameter("userPassword");
        String gender = req.getParameter("gender");
        String birthday = req.getParameter("birthday");
        String phone = req.getParameter("phone");
        String address = req.getParameter("address");
        String userRole = req.getParameter("userRole");

        // 用前端数据实例化 User 实体类对象
        User user = new User();
        user.setUserCode(userCode);
        user.setUserName(userName);
        user.setUserPassword(userPassword);
        user.setGender(Integer.valueOf(gender));
        // 使用 SimpleDateFormat 设置生日
        try {
            user.setBirthday(new SimpleDateFormat("yyyy-MM-dd").parse(birthday));
        } catch (ParseException e) {
            e.printStackTrace();
        }
        user.setPhone(phone);
        user.setAddress(address);
        user.setUserRole(Integer.valueOf(userRole));
        // 设置创建者 -- 需要先获取当前登录的用户实体类对象
        User loginUser = (User) req.getSession().getAttribute(Constants.USER_SESSION);
        user.setCreatedBy(loginUser.getId());
        user.setCreationDate(new Date());

        // 调用 service 层进行提交
        UserServiceImpl userService = new UserServiceImpl();
        if (userService.add(user)) {
            // 添加成功后重定向到用户列表页面
            resp.sendRedirect(req.getContextPath() + "/jsp/user.do?method=query");
        } else {
            // 添加失败则转发回添加用户页面
            req.getRequestDispatcher("useradd.jsp").forward(req, resp);
        }
    }
    //重点，难点
    public void query(HttpServletRequest req,HttpServletResponse resp){

        //从前端获取数据
        String queryUserName=req.getParameter("queryName");
        String temp = req.getParameter("queryUserRole");
        String pageIndex = req.getParameter("pageIndex");
        int queryUserRole=0;
        System.out.println(temp);
        //获取用户列表
        UserServiceImpl userService = new UserServiceImpl();


        //第一次走这个请求，一定是第一页，且页面大小固定
        int pageSize=2;//可以把这个写到配置文件内，方便后期修改
        int currenPageNo=1;//默认从第1页开始
        if(pageIndex!=null){
            currenPageNo=Integer.parseInt(pageIndex);
        }
        if(queryUserName==null){
            queryUserName="";
            //这里不手动赋空值会导致空指针异常
        }
        if(temp!=null&&!temp.equals("")){
            queryUserRole=Integer.parseInt(temp);//前端传过来的数值是对应角色对应的Id
        }

        //获取用户总数量（分页： 上一页，下一页的情况）
        int userCount = userService.getUserCount(queryUserName, queryUserRole);

        //总页数支持
        PageSupport pageSupport = new PageSupport();
        pageSupport.setCurrentPageNo(currenPageNo);
        pageSupport.setPageSize(pageSize);
        pageSupport.setTotalCount(userCount);

        //控制首页和尾页
        int totalPageCount = pageSupport.getTotalPageCount();//总共有几页
        //如果页面<1了，就显示第一页的东西
        if(totalPageCount<1){
            currenPageNo=1;
        }else if(currenPageNo>totalPageCount){
            //当前页面页数大于最后一页
            currenPageNo=totalPageCount;
        }

        //获取用户列表展示
        List<User> userList = userService.getUserList(queryUserName, queryUserRole, currenPageNo, pageSize);

        req.setAttribute("userList",userList);

        RoleServiceImpl roleService = new RoleServiceImpl();
        List<Role> userRoleList = roleService.getUserRoleList();
        req.setAttribute("roleList",userRoleList);

        req.setAttribute("totalCount",userCount);
        req.setAttribute("currentPageNo",currenPageNo);
        req.setAttribute("totalPageCount",totalPageCount);
        req.setAttribute("queryUserName",queryUserName);
        req.setAttribute("queryUserRole",queryUserRole);

        //返回前端
        try {
            req.getRequestDispatcher("userlist.jsp").forward(req,resp);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
    public void updatePwd(HttpServletRequest req,HttpServletResponse resp) throws ServletException, IOException {
        //从Session里面拿ID
        Object attribute = req.getSession().getAttribute(Constants.USER_SESSION);
        String newpassword = req.getParameter("newpassword");

        boolean flag=false;
        if(attribute!=null&& !StringUtils.isNullOrEmpty(newpassword)){
            UserServiceImpl userService = new UserServiceImpl();
            flag = userService.updatePwd(((User) attribute).getId(), newpassword);
            if(flag){
                req.setAttribute("message","修改密码成功，请退出，请使用新密码登录");
                //密码修改成功,移除当前Session
                req.getSession().removeAttribute(Constants.USER_SESSION);
            }else{
                req.setAttribute("message","修改密码失败");
                //密码修改失败，
            }
        }else{
            if(attribute==null){
                System.out.println("attribute");
            }
            if(!StringUtils.isNullOrEmpty(newpassword)){
                System.out.println("newpassword");
            }
            req.setAttribute("message","新密码有问题");
            //新密码有问题
        }
        req.getRequestDispatcher("pwdmodify.jsp").forward(req,resp);

    }

    //验证旧密码
    public void pwdModify(HttpServletRequest req,HttpServletResponse resp){
        //从Session里面拿ID
        Object attribute = req.getSession().getAttribute(Constants.USER_SESSION);
        String oldpassword = req.getParameter("oldpassword");
        //万能的Map:结果集
        HashMap<String, String> resultMap = new HashMap<>();

        if(attribute==null){
            //Session失效了,Session过期了
            resultMap.put("result","sessionerror");

            System.out.println("sessionerror");
        }else if(StringUtils.isNullOrEmpty(oldpassword)){
            //输入的密码为空
            resultMap.put("result","error");
            System.out.println("error");
        }else{
            String userPassword = ((User) attribute).getUserPassword();//Session中用户的密码
            System.out.println(userPassword);
            if(oldpassword.equals(userPassword)){
                System.out.println("true");
                resultMap.put("result","true");
            }else {
                resultMap.put("result","false");
                System.out.println("false");
            }

        }
        try {
            resp.setContentType("application/json");
            PrintWriter writer = resp.getWriter();
            //JSONArray  阿里巴巴的工具类，转换格式
        /*
        resultMap=["result","sessionerror"]
         */
            writer.write(JSONArray.toJSONString(resultMap));
            writer.flush();
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
