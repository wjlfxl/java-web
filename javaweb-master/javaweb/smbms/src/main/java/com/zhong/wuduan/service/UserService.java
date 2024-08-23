package com.zhong.wuduan.service;

import com.zhong.wuduan.pojo.User;

import java.util.List;

/**
 * @author wuduan
 * @version 1.8
 * @date 2022/2/21 20:34
 */
public interface UserService {
    /**
     * 删除用户
     *
     * @param userId 用户的 id
     * @return 返回删除是否成功
     */
    boolean delete(Integer userId);
    /**
     * 新增用户
     *
     * @param user 用户实体类对象
     * @return 返回数据库中受影响的行数
     */
    boolean add(User user);

    //用户登录
    public User login(String userCode,String password);
    
    //根据用户ID修改密码
    public boolean updatePwd(int id,String pwd);

    //查询记录数
    public int getUserCount(String username,int userRole);

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

}
