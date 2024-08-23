package dao;

import com.bean.User;
import com.dao.UserMapper;
import com.utils.MyBatisUtils;
import org.apache.ibatis.session.SqlSession;
import org.apache.log4j.Logger;
import org.junit.Test;

import java.util.HashMap;
import java.util.List;
import java.util.Map;


public class UserMapperTest {

    static Logger logger = Logger.getLogger(UserMapperTest.class);

    @Test
    public void getUserById(){
        SqlSession sqlSession= MyBatisUtils.getSqlSession();

        try {
            UserMapper userMapper =sqlSession.getMapper(UserMapper.class);
            User user=userMapper.getUserById(7);

            System.out.println(user);

        }finally {
            sqlSession.close();
        }
    }


    @Test
    public void getUserLimit(){
        SqlSession sqlSession= MyBatisUtils.getSqlSession();
        HashMap<String,Integer> map=new HashMap<String,Integer>();
        try {
            UserMapper userMapper =sqlSession.getMapper(UserMapper.class);
            map.put("startIndex",0);
            map.put("pageSize",7);
            List<User> userList=userMapper.getUserLimit(map);
            for (User user:userList){
                System.out.println(user);
            }
        }finally {
            sqlSession.close();
        }
    }




    @Test
    public void testLog4j(){
        logger.info("info:进入了log4j方法");
        logger.debug("debug:进入了log4j方法");
        logger.error("error:进入了log4j方法");
    }

}
