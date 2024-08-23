package com.dao;

import com.bean.User;
import com.utils.MyBatisUtils;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import java.util.List;

public class UserMapperTest {



    @Test
    public void getUserLike(){
        SqlSession sqlSession= MyBatisUtils.getSqlSession();

        try {
            //方式一
            UserMapper userMapper =sqlSession.getMapper(UserMapper.class);
            List<User> userList= userMapper.getUserLike("j");

            for (User user:userList){
                System.out.println(user);
            }
        }finally {
            sqlSession.close();
        }
    }



    @Test
    public void test(){
        SqlSession sqlSession= MyBatisUtils.getSqlSession();

        try {
            //方式一
            UserMapper userMapper =sqlSession.getMapper(UserMapper.class);
            List<User> userList= userMapper.getUserList();

            for (User user:userList){
                System.out.println(user);
            }
        }finally {
            sqlSession.close();
        }
    }


    @Test
    public void getUserById(){
        SqlSession sqlSession= MyBatisUtils.getSqlSession();

        try {
            UserMapper userMapper =sqlSession.getMapper(UserMapper.class);
            User user=userMapper.getUserById(2);

            System.out.println(user);

        }finally {
            sqlSession.close();
        }
    }


    //增删改需要提交事务
    @Test
    public void userAdd(){
        SqlSession sqlSession= MyBatisUtils.getSqlSession();

        try {
            UserMapper userMapper =sqlSession.getMapper(UserMapper.class);
            int res =userMapper.userAdd(new User(5,"wjl","12345"));
            if (res>0){
                System.out.println("插入成功！");
            }
//            提交事务
            sqlSession.commit();
        }finally {
            sqlSession.close();
        }
    }

    @Test
    public void updateUser(){
        SqlSession sqlSession= MyBatisUtils.getSqlSession();

        try {
            UserMapper userMapper =sqlSession.getMapper(UserMapper.class);
            userMapper.updateUser(new User(4,"admin","6789"));
//            提交事务
            sqlSession.commit();
        }finally {
            sqlSession.close();
        }
    }

    @Test
    public void getUserDelete(){
        SqlSession sqlSession= MyBatisUtils.getSqlSession();

        try {
            UserMapper userMapper =sqlSession.getMapper(UserMapper.class);
            userMapper.getUserDelete(5);
//            提交事务
            sqlSession.commit();
        }finally {
            sqlSession.close();
        }
    }

}
