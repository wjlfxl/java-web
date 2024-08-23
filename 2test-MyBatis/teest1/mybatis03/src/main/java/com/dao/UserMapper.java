package com.dao;

import com.bean.User;

import java.util.List;


//接口
public interface UserMapper {

// 按id查询
    User getUserById(int id);

}
