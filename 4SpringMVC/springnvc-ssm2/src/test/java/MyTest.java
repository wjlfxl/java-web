import com.pojo.Book;
import com.service.BookService;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MyTest {
    @Test
    public void test(){
        ApplicationContext context=new ClassPathXmlApplicationContext("ApplicationContext.xml");
        BookService bookService= (BookService) context.getBean("BookServiceImpl");
        for (Book book: bookService.getBookList()) {
            System.out.println(book );
        }


    }
}
