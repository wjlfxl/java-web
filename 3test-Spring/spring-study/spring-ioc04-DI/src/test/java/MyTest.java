import com.pojo.Student;
import com.pojo.User;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MyTest {
    public static void main(String[] args) {
        ApplicationContext context=new ClassPathXmlApplicationContext("ApplicationContext.xml");
        Student student=(Student) context.getBean("student");
        System.out.println(student.toString());
    }

    @Test
    public void UserTest(){
        ApplicationContext context=new ClassPathXmlApplicationContext("Userbeams.xml");
//        User user=(User) context.getBean("user");
        User user=context.getBean("user",User.class);

        System.out.println(user);
    }

    @Test
    public void User2Test(){
        ApplicationContext context=new ClassPathXmlApplicationContext("Userbeams.xml");
//        User user=(User) context.getBean("user");
        User user=context.getBean("user2",User.class);

        System.out.println(user);
    }
}
