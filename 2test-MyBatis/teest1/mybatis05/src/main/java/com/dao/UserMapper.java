package com.dao;

import com.bean.User;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.List;
import java.util.Map;

public interface UserMapper {

    @Select("SELECT * FROM cart.user")
    List<User> getUsers();

//    @Select("SELECT * FROM cart.user where id=#{id} and name=#{names}")
//    User getUserById(@Param("id") int id,@Param("names") String name);
    @Select("SELECT * FROM cart.user where id=#{id}")
    User getUserById(@Param("id") int id);

    @Insert("insert into cart.user values (#{id},#{name},#{password})")
    int addUser(User user);

    @Update("update cart.user set name = #{name},password=#{password} where id=#{id};")
    int updataUser(User user);
}
