package dao;

import com.bean.User;
import com.dao.UserMapper;
import com.utils.MyBatisUtils;
import org.apache.ibatis.session.SqlSession;
import org.apache.log4j.Logger;
import org.junit.Test;

import java.util.HashMap;
import java.util.List;
import java.util.Scanner;


public class UserMapperTest {

    @Test
    public void test(){
        SqlSession sqlSession=MyBatisUtils.getSqlSession();
        UserMapper mapper=sqlSession.getMapper(UserMapper.class);
        List<User> users=mapper.getUsers();
        for (User user:users){
            System.out.println(user);
        }
        sqlSession.close();
    }


    @Test
    public void getUserById(){
        SqlSession sqlSession=MyBatisUtils.getSqlSession();
        UserMapper mapper=sqlSession.getMapper(UserMapper.class);
        User users=mapper.getUserById(7);
        System.out.println(users);
        sqlSession.close();
    }

    @Test
    public void addUser(){
        SqlSession sqlSession=MyBatisUtils.getSqlSession();
        UserMapper mapper=sqlSession.getMapper(UserMapper.class);

        mapper.addUser(new User(10,"陈十","1234"));
        //        提交事务
        sqlSession.commit();
        sqlSession.close();
    }

    @Test
    public void updataUser(){
        SqlSession sqlSession=MyBatisUtils.getSqlSession();
        UserMapper mapper=sqlSession.getMapper(UserMapper.class);

        mapper.updataUser(new User(8,"王五物","1234"));
        //        提交事务
        sqlSession.commit();
        sqlSession.close();
    }

}
