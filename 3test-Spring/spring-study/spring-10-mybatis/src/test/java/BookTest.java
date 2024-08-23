import com.bean.Book;
import com.dao.BookMapper;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class BookTest {

    @Test
    public void getBookList(){
        ApplicationContext context=new ClassPathXmlApplicationContext("ApplicationContext.xml");
        BookMapper mapper=context.getBean("bookMapper",BookMapper.class);
        List<Book> books=mapper.getBookList();
        for (Book book:books){
            System.out.println(book);
        }

    }

    @Test
    public void getBookIf(){
        ApplicationContext context=new ClassPathXmlApplicationContext("ApplicationContext.xml");
        BookMapper mapper=context.getBean("bookMapper",BookMapper.class);
        HashMap hashMap=new HashMap();
//        hashMap.put("name","热");
//        hashMap.put("author","鲁");
        List<Book> books= mapper.getBookIf(hashMap);
        for (Book book:books){
            System.out.println(book);
        }

    }

    @Test
    public void getBookChoose(){
        ApplicationContext context=new ClassPathXmlApplicationContext("ApplicationContext.xml");
        BookMapper mapper=context.getBean("bookMapper",BookMapper.class);
        HashMap hashMap=new HashMap();
        hashMap.put("name","人");
        hashMap.put("author","鲁");
        List<Book> books= mapper.getBookChoose(hashMap);
        for (Book book:books){
            System.out.println(book);
        }

    }

    @Test
    public void getBookWhere(){
        ApplicationContext context=new ClassPathXmlApplicationContext("ApplicationContext.xml");
        BookMapper mapper=context.getBean("bookMapper",BookMapper.class);
        HashMap hashMap=new HashMap();
        hashMap.put("name","热");
        hashMap.put("author","鲁");
        List<Book> books= mapper.getBookWhere(hashMap);
        for (Book book:books){
            System.out.println(book);
        }

    }

    @Test
    public void upDateBook(){
        ApplicationContext context=new ClassPathXmlApplicationContext("ApplicationContext.xml");
        BookMapper mapper=context.getBean("bookMapper",BookMapper.class);
        HashMap hashMap=new HashMap();
        hashMap.put("name","解忧杂货店");
        hashMap.put("author","东野圭吾");
        hashMap.put("id",1);
        mapper.upDateBook(hashMap);


    }

    @Test
    public void getBookIn(){
        ApplicationContext context=new ClassPathXmlApplicationContext("ApplicationContext.xml");
        BookMapper mapper=context.getBean("bookMapper",BookMapper.class);
        HashMap map=new HashMap();
        map.put("val1",1);
        map.put("val2",4);
        map.put("val3",9);
        List<Book> books= mapper.getBookIn(map);
        for (Book book:books){
            System.out.println(book);
        }

    }

    @Test
    public void getBookForeach(){
//        Cache
        ApplicationContext context=new ClassPathXmlApplicationContext("ApplicationContext.xml");
        BookMapper mapper=context.getBean("bookMapper",BookMapper.class);
        ArrayList<Integer> arrayList=new ArrayList();
        arrayList.add(5);
        arrayList.add(2);

        HashMap map=new HashMap();
        map.put("ids",arrayList);
        List<Book> books= mapper.getBookForeach(map);
        for (Book book:books){
            System.out.println(book);
        }

    }

}
