import com.bean.BookCase;
import com.dao.BookCaseMapper;
import com.utils.MyBatisUtils;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import java.util.List;

public class BookcaseTest {


    @Test
    public void getBookCase(){
        SqlSession sqlSession= MyBatisUtils.getSqlSession();
        BookCaseMapper mapper=sqlSession.getMapper(BookCaseMapper.class);
        List<BookCase> bookCases= mapper.getBookCaseById(5);
        System.out.println(bookCases);
        sqlSession.close();
    }


    @Test
    public void getBookCaseById2(){
        SqlSession sqlSession= MyBatisUtils.getSqlSession();
        BookCaseMapper mapper=sqlSession.getMapper(BookCaseMapper.class);
        List<BookCase> bookCases= mapper.getBookCaseById2(5);
        System.out.println(bookCases);
        sqlSession.close();
    }
}
