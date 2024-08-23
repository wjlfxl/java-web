package com.dao;

import com.bean.User;

import java.util.List;
import java.util.Map;


//接口
public interface UserMapper {

    //模糊查询
    List<User> getUserLike(String val);



    //查询，按id查询，
    List<User> getUserList();
// 按id查询
    User getUserById(int id);

//    User getUserById2(Map<String,Object> map);

//    添加
    int userAdd(User user);

//    int userAdd2(Map<String,Object> map);

//    修改
    int updateUser(User user);
//    删除
    int getUserDelete(int id);
}
