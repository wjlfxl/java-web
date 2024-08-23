import com.bean.User;
import com.dao.UserMapper;
import com.utils.MyBatisUtils;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import java.util.List;

public class UserTest {

        @Test
    public void getUser(){
        SqlSession sqlSession= MyBatisUtils.getSqlSession();
        UserMapper mapper=sqlSession.getMapper(UserMapper.class);
        User users= mapper.getUser(5);
        System.out.println(users);
        sqlSession.close();

//        sqlSession.clearCache();//清理缓存


        SqlSession sqlSession2= MyBatisUtils.getSqlSession();
        UserMapper mapper2=sqlSession2.getMapper(UserMapper.class);
        User users2= mapper2.getUser(5);
        System.out.println(users2);

        System.out.println(users==users2);
        sqlSession2.close();
    }

}
