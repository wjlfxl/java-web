package com.zhong.wuduan.service;

import com.zhong.wuduan.dao.BaseDao;
import com.zhong.wuduan.dao.user.UserDao;
import com.zhong.wuduan.dao.user.UserDaoImp;
import com.zhong.wuduan.pojo.User;
import org.junit.Test;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

/**
 * @author wuduan
 * @version 1.8
 * @date 2022/2/21 20:33
 */
public class UserServiceImpl implements UserService{

//业务层都会调用Dao层，所以我们要引入Dao
    private UserDao userDao;

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
    @Override
    public List<User> getUserList(String userName, int userRole, int currentPageNo, int pageSize) {
        Connection connection = BaseDao.getConnection();
        List<User> userList = null;

        try {
            userList = userDao.getUserlist(connection, userName, userRole, currentPageNo, pageSize);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } finally {
            BaseDao.closeResource(connection, null, null);
        }

        return userList;
    }

    @Override
    public int getUserCount(String username, int userRole) {
        Connection connection=null;
        int userCount=0;
        try {
             connection = BaseDao.getConnection();
             userCount = userDao.getUserCount(connection, username, userRole);
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            BaseDao.closeResource(connection,null,null);
        }
        return userCount;
    }
    @Test
    public void test1(){
        UserServiceImpl userService = new UserServiceImpl();
        int userCount = userService.getUserCount(null, 1);
        System.out.println(userCount);
    }
    @Override
    public boolean updatePwd(int id, String pwd) {
        Connection connection=null;
        connection=BaseDao.getConnection();
        boolean flag=false;
        //修改密码
        try {
            if(userDao.updatePwd(connection,id,pwd)>0){
    flag=true;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            BaseDao.closeResource(connection,null,null);
        }

        return flag;
    }

    public UserServiceImpl(){
    userDao=new UserDaoImp();
}

    @Override
    public User login(String userCode, String password) {
        Connection connection=null;
        User user=null;
        try {
            connection=BaseDao.getConnection();
            //通过业务层调用对应的具体数据库操作
            user=userDao.getLoginUser(connection,userCode);
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            BaseDao.closeResource(connection,null,null);
        }
        return user;
    }
    /*
    测试
    @Test
    public void test(){
        UserServiceImpl userService = new UserServiceImpl();
        User admin = userService.login("admin", "1234567");
        System.out.println(admin.getUserPassword());
    }

     */
}
