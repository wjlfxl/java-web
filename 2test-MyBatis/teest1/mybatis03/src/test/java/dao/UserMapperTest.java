package dao;

import com.bean.User;
import com.dao.UserMapper;
import com.utils.MyBatisUtils;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import java.util.List;

public class UserMapperTest {

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

}
