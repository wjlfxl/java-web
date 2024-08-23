package com.plasticine.service.user;

import com.plasticine.pojo.User;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

public interface UserService {

    /**
     * 登录验证
     *
     * @param userCode 用户编号
     * @param password 输入的密码
     * @return 登陆成功则会返回用户对象
     */
    User login(String userCode, String password);

    /**
     * 修改密码
     *
     * @param id       用户id
     * @param password 用户密码
     * @return 是否修改成功
     */
    boolean updatePwd(int id, String password);

    /**
     * 根据用户名或角色 id 查询用户总数
     *
     * @param username 用户名
     * @param userRole 角色 id
     * @return 返回查询到的符合条件的用户数量
     */
    int getUserCount(String username, int userRole);

    /**
     * 通过条件查询用户列表
     *
     * @param userName      用户名
     * @param userRole      角色 id
     * @param currentPageNo 当前分页的页号
     * @param pageSize      分页的每页大小
     * @return 返回符合条件的用户列表
     */
    List<User> getUserList(String userName, int userRole, int currentPageNo, int pageSize);

    /**
     * 新增用户
     *
     * @param user 用户实体类对象
     * @return 返回数据库中受影响的行数
     */
    boolean add(User user);

    /**
     * 检查用户编号是否已存在
     *
     * @param userCode 用户编号
     * @return 用户编号存在则返回用户实体类对象，不存在则返回空
     */
    User selectUserCodeExist(String userCode);

    /**
     * 删除用户
     *
     * @param userId 用户的 id
     * @return 返回删除是否成功
     */
    boolean delete(Integer userId);

    /**
     * 通过 id 查询用户
     *
     * @param userId 用户的 id
     * @return 返回根据 id 查询到的用户实体类对象
     */
    User getUserById(Integer userId);

    /**
     * 更新用户
     *
     * @param user 用户实体类对象
     * @return 返回更新是否成功
     */
    boolean modifyUser(User user);
}
