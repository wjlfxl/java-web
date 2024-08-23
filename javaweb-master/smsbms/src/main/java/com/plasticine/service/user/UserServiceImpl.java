package com.plasticine.service.user;

import com.plasticine.dao.BaseDao;
import com.plasticine.dao.user.UserDao;
import com.plasticine.dao.user.UserDaoImpl;
import com.plasticine.pojo.User;
import org.junit.Test;

import java.sql.Connection;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

public class UserServiceImpl implements UserService {

    private UserDao userDao;

    public UserServiceImpl() {
        this.userDao = new UserDaoImpl();
    }

    /**
     * 实现校验用户登录逻辑 -- 即校验用户编号和密码是否正确
     *
     * @param userCode 用户编号
     * @param password 输入的密码
     * @return 校验通过返回用户对象，否则返回 null
     */
    public User login(String userCode, String password) {

        Connection connection = null;
        User user = null;

        try {
            connection = BaseDao.getConnection();
            user = this.userDao.getLoginUser(connection, userCode);
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            BaseDao.closeResource(connection, null, null);
        }

        if (user.getUserPassword().equals(password)) {
            return user;
        }

        return null;
    }

    // 修改密码
    public boolean updatePwd(int id, String password) {
        Connection connection = BaseDao.getConnection();
        boolean isSucceed;

        // 调用Dao层修改密码
        isSucceed = userDao.updatePwd(connection, id, password);

        // 关闭连接
        BaseDao.closeResource(connection, null, null);

        return isSucceed;
    }

    // 根据用户名或角色 id 查询用户总数
    public int getUserCount(String username, int userRole) {
        Connection connection = BaseDao.getConnection();
        int count = 0;

        try {
            count = userDao.getUserCount(connection, username, userRole);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } finally {
            BaseDao.closeResource(connection, null, null);
        }

        return count;
    }

    // 通过条件查询用户列表
    public List<User> getUserList(String userName, int userRole, int currentPageNo, int pageSize) {
        Connection connection = BaseDao.getConnection();
        List<User> userList = null;

        try {
            userList = userDao.getUserList(connection, userName, userRole, currentPageNo, pageSize);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } finally {
            BaseDao.closeResource(connection, null, null);
        }

        return userList;
    }

    // 新增用户
    public boolean add(User user) {
        Connection connection = BaseDao.getConnection();
        boolean flag = false;

        try {
            // 开启 JDBC 事务管理 -- 即关闭自动 COMMIT
            connection.setAutoCommit(false);
            int updateRows = userDao.add(connection, user);
            connection.commit();
            if (updateRows > 0) {
                flag = true;
                System.out.println("add user success!");
            } else {
                System.out.println("add user fail!");
            }
        } catch (SQLException e) { // 事务失败 -- 回滚
            e.printStackTrace();
            try {
                System.out.println("===========user add RollBack===========");
                connection.rollback();
            } catch (SQLException e1) {
                e1.printStackTrace();
            }
        } finally {
            BaseDao.closeResource(connection, null, null);
        }

        return flag;
    }

    // 检查用户编号是否已存在
    public User selectUserCodeExist(String userCode) {
        Connection connection = BaseDao.getConnection();
        User loginUser = null;

        if (connection != null) {
            try {
                loginUser = userDao.getLoginUser(connection, userCode);
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            } finally {
                BaseDao.closeResource(connection, null, null);
            }
        }

        return loginUser;
    }

    // 删除用户
    public boolean delete(Integer userId) {
        Connection connection = BaseDao.getConnection();
        boolean flag = false;

        try {
            int updateRows = userDao.delete(connection, userId);
            if (updateRows > 0) flag = true;
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } finally {
            BaseDao.closeResource(connection, null, null);
        }

        return flag;
    }

    // 根据 id 查询用户
    public User getUserById(Integer userId) {
        Connection connection = BaseDao.getConnection();
        User user = null;

        try {
            user = userDao.getUserById(connection, userId);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } finally {
            BaseDao.closeResource(connection, null, null);
        }

        return user;
    }

    // 更新用户
    public boolean modifyUser(User user) {
        Connection connection = BaseDao.getConnection();
        boolean flag = false;

        try {
            int updateRows = userDao.modifyUser(connection, user);
            if (updateRows > 0) flag = true;
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } finally {
            BaseDao.closeResource(connection, null, null);
        }

        return flag;
    }

    @Test
    public void testGetUserList() {
        UserServiceImpl userService = new UserServiceImpl();
        List<User> userList = userService.getUserList(null, 0, 1, 5);
        System.out.println(userList.toArray().length);
        for (User user : userList) {
            System.out.println(user.getUserName());
        }
    }

    @Test
    public void testAddUser() {
        UserServiceImpl userService = new UserServiceImpl();
        User user = new User();

        user.setUserCode("666");
        user.setUserName("草帽Plasticine");
        user.setUserPassword("hahaha666");
        user.setGender(1);
        // 使用 SimpleDateFormat 设置生日
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        try {
            Date birthday = sdf.parse("2001-07-19");
            user.setBirthday(birthday);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        user.setPhone("13798916602");
        user.setAddress("广东省东莞市大岭山镇");
        user.setUserRole(1);
        user.setCreatedBy(1);
        // 设置当前时间
        java.sql.Timestamp curTime = new java.sql.Timestamp(new Date().getTime());
        user.setCreationDate(curTime);

        boolean isAdded = userService.add(user);
        if (isAdded) System.out.println("添加成功！");
        else System.out.println("添加失败");
    }

    @Test
    public void testGetUserById() {
        UserServiceImpl userService = new UserServiceImpl();
        User user = userService.getUserById(1);
        System.out.println(user.getUserName());
    }

    @Test
    public void testModifyUser() throws ParseException {
        UserServiceImpl userService = new UserServiceImpl();
        User user = new User();
        user.setId(15);
        user.setUserName("hahah");
        user.setGender(1);
        // 设置生日 -- 用 SimpleDateFormat
//        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
//        Date birthdat = sdf.parse("2001-07-19");
        user.setBirthday(new SimpleDateFormat("yyyy-MM-dd").parse("2001-07-19"));
        user.setPhone("13798916602");
        user.setAddress("山旮旯");
        user.setUserRole(1);

        boolean isModified = userService.modifyUser(user);
        if (isModified) System.out.println("修改成功！");
        else System.out.println("修改失败");
    }
}
