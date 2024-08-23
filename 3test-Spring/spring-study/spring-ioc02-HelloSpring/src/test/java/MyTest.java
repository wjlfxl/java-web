import com.pojo.Hello;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MyTest {
    public static void main(String[] args) {
        //获取spring的上下文对象
        ApplicationContext context = new ClassPathXmlApplicationContext("ApplicationContext.xml");

        //我们的对象现在都在spring中管理,我们要使用直接取出来就好
        Hello hello =(Hello) context.getBean("Hello");
        System.out.println(hello);
    }
}
