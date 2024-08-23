package com.plasticine.servlet.user;

import com.alibaba.fastjson.JSONArray;
import com.mysql.cj.util.StringUtils;
import com.plasticine.pojo.Role;
import com.plasticine.pojo.User;
import com.plasticine.service.role.RoleServiceImpl;
import com.plasticine.service.user.UserServiceImpl;
import com.plasticine.util.Constants;

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

public class UserServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String method = req.getParameter("method");
        // 封装修改密码的请求
        if ("savepwd".equals(method)) {
            this.updatePwd(req, resp);
        }
        if ("pwdmodify".equals(method)) {
            this.oldPwdModifyCheck(req, resp);
        }
        if ("query".equals(method)) {
            this.query(req, resp);
        }
        if ("add".equals(method)) {
            this.add(req, resp);
        }
        if ("getrolelist".equals(method)) {
            this.getRoleList(req, resp);
        }
        if ("ucexist".equals(method)) {
            this.userCodeExist(req, resp);
        }
        if ("deluser".equals(method)) {
            this.deluser(req, resp);
        }
        if ("view".equals(method)) {
            this.view(req, resp, "userview.jsp");
        }
        if ("modify".equals(method)) {
            this.view(req, resp, "usermodify.jsp");
        }
        if ("modifyexe".equals(method)) {
            this.modify(req, resp);
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }

    /**
     * 处理修改密码逻辑
     */
    public void updatePwd(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // 从 session 里面拿 id
        Object user = req.getSession().getAttribute(Constants.USER_SESSION);

        // 获取前端传入的参数
        String newpassword = req.getParameter("newpassword");

        // 用户存在，且传入的密码不是空的
        if (user != null && !StringUtils.isNullOrEmpty(newpassword)) {
            // 调用业务层修改密码
            UserServiceImpl userService = new UserServiceImpl();
            Integer id = ((User) user).getId();

            boolean isSucceed = userService.updatePwd(id, newpassword);
            if (isSucceed) {
                req.setAttribute("message", "密码修改成功！");
                // 移除当前 session 中的 USER_SESSION 属性
                req.getSession().removeAttribute(Constants.USER_SESSION);
            } else {
                req.setAttribute("message", "密码修改失败！");
            }
        } else {
            req.setAttribute("message", "请输入新密码！");
        }

        req.getRequestDispatcher("/login.jsp").forward(req, resp);
    }

    /**
     * 校验旧密码是否正确
     */
    public void oldPwdModifyCheck(HttpServletRequest req, HttpServletResponse resp) {

        // 获取用户传入的旧密码
        String oldPassword = req.getParameter("oldpassword");

        // 获取 session 中的旧密码
        Object user = req.getSession().getAttribute(Constants.USER_SESSION);
        String oldPasswordInSession = ((User) user).getUserPassword();

        // 构造返回的对象 -- 用 HashMap
        HashMap<String, String> resultMap = new HashMap<String, String>();

        // session 过期
        if (user == null)
            resultMap.put("result", "sessionerror");
        // 输入的密码为空
        if (StringUtils.isNullOrEmpty(oldPassword))
            resultMap.put("result", "error");
        // 对比传入的旧密码与 session 中的旧密码是否相等
        if (oldPassword.equals(oldPasswordInSession))
            resultMap.put("result", "true");
        else
            resultMap.put("result", "false");

        // 返回 resultMap -- 使用阿里巴巴的工具类 fastjson 进行序列化
        try {
            // 设置返回的数据类型为 json
            resp.setContentType("application/json");
            // 将 HashMap 对象序列化成 json 字符串后再返回
            PrintWriter writer = resp.getWriter();
            writer.write(JSONArray.toJSONString(resultMap));

            // 关闭输出流
            writer.flush();
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * 处理用户模块的查询逻辑 -- 用户列表、角色列表、分页
     */
    public void query(HttpServletRequest req, HttpServletResponse resp) {

        UserServiceImpl userService = new UserServiceImpl();
        RoleServiceImpl roleService = new RoleServiceImpl();

        // 获取前端的参数
        String queryUserName = req.getParameter("queryname");
        String tmpUserRole = req.getParameter("queryUserRole");     // 这里获取到的可能是空
        String pageIndex = req.getParameter("pageIndex");
        int queryUserRole = 0;

        // 分页逻辑
        int pageSize = 5;       // 每页展示的数据条数
        int currentPageNo = 1;  // 第一次进来一定是第一页，如果 pageIndex 不为空则用 pageIndex 覆盖 currentPageNo

        // 没有传入用户名查询时则让其为空字符串
        if (queryUserName == null)
            queryUserName = "";

        // 前端有传入用户角色，则进行处理，将传入的 userRole 字符串转为 Integer
        if (tmpUserRole != null && !tmpUserRole.equals(""))
            queryUserRole = Integer.parseInt(tmpUserRole);

        // pageIndex 不为空则使用 pageIndex 作为当前页
        if (pageIndex != null)
            currentPageNo = Integer.parseInt(pageIndex);

        // 调用用户的业务层，获取用户总数
        int totalCount = userService.getUserCount(queryUserName, queryUserRole);

        // 计算总页数 -- 用户总数除以每页数量即可，由于可能除不尽，这时候需要向上取整，用 Math.ceil()
        int totalPageCount = (int) Math.ceil((double) totalCount / (double) pageSize);

        // 首页以及尾页控制
        if (currentPageNo < 1)
            currentPageNo = 1;
        if (currentPageNo > totalPageCount)
            currentPageNo = totalPageCount;

        // 调用用户的业务层，获取用户列表
        List<User> userList = userService.getUserList(queryUserName, queryUserRole, currentPageNo, pageSize);

        // 调用用户角色的业务层，获取用户角色列表
        List<Role> userRoleList = roleService.getUserRoleList();

        // 设置返回给前端的参数
        req.setAttribute("userList", userList);
        req.setAttribute("roleList", userRoleList);
        req.setAttribute("totalCount", totalCount);
        req.setAttribute("currentPageNo", currentPageNo);
        req.setAttribute("totalPageCount", totalPageCount);

        // 转发到 userlist.jsp
        try {
            req.getRequestDispatcher("userlist.jsp").forward(req, resp);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
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
     * 校验用户是否已存在
     */
    public void userCodeExist(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        // 获取用户编号 -- 调用 service 层去查
        String userCode = req.getParameter("userCode");
        // resMap 哈希表用于返回 json 格式数据
        HashMap<String, String> resMap = new HashMap<String, String>();

        // 用户编号为空 -- 当成已存在
        if (StringUtils.isNullOrEmpty(userCode))
            resMap.put("userCode", "exist");
        else {
            UserServiceImpl userService = new UserServiceImpl();
            // 调用 service 层查询用户是否存在
            User user = userService.selectUserCodeExist(userCode);
            if (user != null)
                resMap.put("userCode", "exist");
            else
                resMap.put("userCode", "not_exist");
        }

        // 把 resMap 转为 json 字符串返回
        resp.setContentType("application/json");
        PrintWriter writer = resp.getWriter();
        writer.write(JSONArray.toJSONString(resMap));
        writer.flush();
        writer.close();
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

    /**
     * 浏览用户详细信息
     */
    public void view(HttpServletRequest req, HttpServletResponse resp, String url) throws IOException, ServletException {
        // 获取前端参数 -- 用户 id
        String userIdStr = req.getParameter("uid");
        int userId = 0;
        User user = null;

        // 未传入 uid 时，userId 指定为0，后面遇到 userId 为 0 就返回 null
        if (StringUtils.isNullOrEmpty(userIdStr)) {
            userId = 0;
        }

        try {
            userId = Integer.parseInt(userIdStr);
        } catch (Exception e) {
            e.printStackTrace();
        }

        if (userId > 0) {
            UserServiceImpl userService = new UserServiceImpl();
            user = userService.getUserById(userId);
        }

        req.setAttribute("user", user);
        req.getRequestDispatcher(url).forward(req, resp);
    }

    /**
     * 修改用户信息
     */
    public void modify(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
        // 获取前端传入的信息
        String userId = req.getParameter("uid");
        String userName = req.getParameter("userName");
        String gender = req.getParameter("gender");
        String birthday = req.getParameter("birthday");
        String phone = req.getParameter("phone");
        String address = req.getParameter("address");
        String userRole = req.getParameter("userRole");

        User user = new User();
        user.setId(Integer.parseInt(userId));
        user.setUserName(userName);
        user.setGender(Integer.parseInt(gender));
        try {
            user.setBirthday(new SimpleDateFormat("yyyy-MM-dd").parse(birthday));
        } catch (ParseException e) {
            e.printStackTrace();
        }
        user.setPhone(phone);
        user.setAddress(address);
        user.setUserRole(Integer.parseInt(userRole));

        UserServiceImpl userService = new UserServiceImpl();
        boolean isModified = userService.modifyUser(user);

        if (isModified) {
            resp.sendRedirect(req.getContextPath() + "/jsp/user.do?method=query");
        } else {
            req.getRequestDispatcher("usermodify.jsp").forward(req, resp);
        }
    }

}
