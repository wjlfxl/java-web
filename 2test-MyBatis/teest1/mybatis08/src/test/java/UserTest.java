import com.bean.Book;
import com.dao.BookMapper;
import com.utils.MyBatisUtils;
import org.apache.ibatis.cache.Cache;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class UserTest {

    @Test
    public void getBookList(){
        SqlSession sqlSession=MyBatisUtils.getSqlSession();
        BookMapper mapper=sqlSession.getMapper(BookMapper.class);
        List<Book> books= mapper.getBookList();
        for (Book book:books){
            System.out.println(book);
        }
        sqlSession.close();
    }

    @Test
    public void getBookIf(){
        SqlSession sqlSession=MyBatisUtils.getSqlSession();
        BookMapper mapper=sqlSession.getMapper(BookMapper.class);
        HashMap hashMap=new HashMap();
//        hashMap.put("name","热");
//        hashMap.put("author","鲁");
        List<Book> books= mapper.getBookIf(hashMap);
        for (Book book:books){
            System.out.println(book);
        }
        sqlSession.close();
    }

    @Test
    public void getBookChoose(){
        SqlSession sqlSession=MyBatisUtils.getSqlSession();
        BookMapper mapper=sqlSession.getMapper(BookMapper.class);
        HashMap hashMap=new HashMap();
        hashMap.put("name","人");
        hashMap.put("author","鲁");
        List<Book> books= mapper.getBookChoose(hashMap);
        for (Book book:books){
            System.out.println(book);
        }
        sqlSession.close();
    }

    @Test
    public void getBookWhere(){
        SqlSession sqlSession=MyBatisUtils.getSqlSession();
        BookMapper mapper=sqlSession.getMapper(BookMapper.class);
        HashMap hashMap=new HashMap();
        hashMap.put("name","热");
        hashMap.put("author","鲁");
        List<Book> books= mapper.getBookWhere(hashMap);
        for (Book book:books){
            System.out.println(book);
        }
        sqlSession.close();
    }

    @Test
    public void upDateBook(){
        SqlSession sqlSession=MyBatisUtils.getSqlSession();
        BookMapper mapper=sqlSession.getMapper(BookMapper.class);
        HashMap hashMap=new HashMap();
        hashMap.put("name","解忧杂货店");
        hashMap.put("author","东野圭吾");
        hashMap.put("id",1);
        mapper.upDateBook(hashMap);

        sqlSession.commit();
        sqlSession.close();
    }

    @Test
    public void getBookIn(){
        SqlSession sqlSession=MyBatisUtils.getSqlSession();
        BookMapper mapper=sqlSession.getMapper(BookMapper.class);
        List<Book> books= mapper.getBookIn();
        for (Book book:books){
            System.out.println(book);
        }
        sqlSession.close();
    }

    @Test
    public void getBookForeach(){
//        Cache
        SqlSession sqlSession=MyBatisUtils.getSqlSession();
        BookMapper mapper=sqlSession.getMapper(BookMapper.class);
        ArrayList<Integer> arrayList=new ArrayList();
        arrayList.add(5);
        arrayList.add(2);

        HashMap map=new HashMap();
        map.put("ids",arrayList);
        List<Book> books= mapper.getBookForeach(map);
        for (Book book:books){
            System.out.println(book);
        }
        sqlSession.close();
    }

}
