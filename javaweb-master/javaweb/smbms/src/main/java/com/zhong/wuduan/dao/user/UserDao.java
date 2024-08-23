package com.zhong.wuduan.dao.user;

import com.zhong.wuduan.pojo.User;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

/**
 * @author wuduan
 * @version 1.8
 * @date 2022/2/20 22:47
 */
public interface UserDao {

    /**
     * 删除用户
     *
     * @param connection 数据库连接对象
     * @param userId     用户的 id
     * @return 返回数据库中受影响的行数
     */
    int delete(Connection connection, Integer userId) throws SQLException;
    //得到要登录的用户
    public User getLoginUser(Connection connection,String userCode) throws SQLException;

    //修改当前用户密码
    public int updatePwd(Connection connection,int id,String password)throws  SQLException;
    
    //查询用户总数
    public int getUserCount(Connection connection,String username,int userRole) throws SQLException;

    //获取用户列表
    public List<User> getUserlist(Connection connection,String userName,int userRole,int currentPageNo,int pageSize) throws SQLException;

    /**
     * 添加新用户
     *
     * @param connection 数据库连接对象
     * @param user       用户实体类对象
     * @return 返回数据库中受影响的行数
     */
    int add(Connection connection, User user) throws SQLException;
}
