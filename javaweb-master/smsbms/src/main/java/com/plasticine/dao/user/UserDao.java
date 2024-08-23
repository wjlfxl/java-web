package com.plasticine.dao.user;

import com.plasticine.pojo.User;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

public interface UserDao {

    /**
     * 得到登录的用户
     *
     * @param connection 数据库连接对象
     * @param userCode   用户编码
     * @return 返回用户对象
     */
    User getLoginUser(Connection connection, String userCode) throws SQLException;

    /**
     * 修改当前用户的密码
     *
     * @param connection 数据库连接对象
     * @param id         用户id
     * @param password   要修改的密码
     * @return 返回是否修改成功
     */
    boolean updatePwd(Connection connection, int id, String password);

    /**
     * 根据用户名或角色 id 查询用户总数
     *
     * @param connection 数据库连接对象
     * @param username   用户名
     * @param userRole   角色 id
     * @return 返回查询到的符合条件的用户数量
     */
    int getUserCount(Connection connection, String username, int userRole) throws SQLException;

    /**
     * 通过条件查询用户列表
     *
     * @param connection    数据库连接对象
     * @param userName      用户名
     * @param userRole      角色 id
     * @param currentPageNo 当前分页的页号
     * @param pageSize      分页的每页大小
     * @return 返回符合条件的用户列表
     */
    List<User> getUserList(Connection connection, String userName, int userRole, int currentPageNo, int pageSize) throws SQLException;

    /**
     * 添加新用户
     *
     * @param connection 数据库连接对象
     * @param user       用户实体类对象
     * @return 返回数据库中受影响的行数
     */
    int add(Connection connection, User user) throws SQLException;

    /**
     * 删除用户
     *
     * @param connection 数据库连接对象
     * @param userId     用户的 id
     * @return 返回数据库中受影响的行数
     */
    int delete(Connection connection, Integer userId) throws SQLException;

    /**
     * 通过 id 查询用户
     *
     * @param connection 数据库连接对象
     * @param userId     用户的 id
     * @return 返回根据 id 查询到的用户实体类对象
     */
    User getUserById(Connection connection, Integer userId) throws SQLException;

    /**
     * 修改用户
     *
     * @param connection 数据库连接对象
     * @param user       用户实体类对象
     * @return 返回数据库中受影响的行数
     */
    int modifyUser(Connection connection, User user) throws SQLException;
}
