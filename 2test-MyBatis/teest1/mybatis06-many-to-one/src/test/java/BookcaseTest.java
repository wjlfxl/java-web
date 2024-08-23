import com.bean.Book;
import com.bean.BookCase;
import com.dao.BookCaseMapper;
import com.dao.BookMapper;
import com.utils.MyBatisUtils;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

public class BookcaseTest {

    @Test
    public void getBookCaseById(){
        SqlSession sqlSession= MyBatisUtils.getSqlSession();
        BookCaseMapper mapper=sqlSession.getMapper(BookCaseMapper.class);
        BookCase bookCase= mapper.getBookCaseById(3);
        System.out.println(bookCase);
        sqlSession.close();
    }
}
