import com.bean.Book;
import com.dao.BookMapper;
import com.utils.MyBatisUtils;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import java.util.List;

public class BookTest {
    @Test
    public void getBookList(){
        SqlSession sqlSession= MyBatisUtils.getSqlSession();
        BookMapper mapper=sqlSession.getMapper(BookMapper.class);
        List<Book> books=mapper.getBookList();
        for (Book book:books){
            System.out.println(book);
        }
        sqlSession.close();
    }

    @Test
    public void getBookList2(){
        SqlSession sqlSession= MyBatisUtils.getSqlSession();
        BookMapper mapper=sqlSession.getMapper(BookMapper.class);
        List<Book> books=mapper.getBookList2();
        for (Book book:books){
            System.out.println(book);
        }
        sqlSession.close();
    }

}
