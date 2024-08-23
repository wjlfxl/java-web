import com.pojo.User;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class UserTest {
    public static void main(String[] args) {
       ApplicationContext context= new ClassPathXmlApplicationContext("ApplicationContext.xml");
       //名字是默认类是小写
       User user=context.getBean("user", User.class);
       System.out.println(user.name);
    }
}
