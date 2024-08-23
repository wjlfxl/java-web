package com.dao;

import com.bean.User;

import java.util.List;


//接口
public interface UserMapper {

    //模糊查询
    List<User> getUserLike(String val);

    //查询
    List<User> getUserList();
// 按id查询
    User getUserById(int id);

//    添加
    int userAdd(User user);

//    修改
    int updateUser(User user);

//    删除
    int getUserDelete(int id);
}
