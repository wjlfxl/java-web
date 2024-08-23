package com.dao;

import com.bean.User;

import java.util.List;
import java.util.Map;


//接口
public interface UserMapper {

// 按id查询
    User getUserById(int id);

    // 分页
    List<User> getUserLimit(Map<String,Integer> map);

}
