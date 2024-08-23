import com.pojo.People;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class PeopleTest {
    public static void main(String[] args) {
        ApplicationContext context=new ClassPathXmlApplicationContext("ApplicationContext.xml");
        People people=context.getBean("people", People.class);
        people.getDog().shout();
        people.getCat().shout();
    }
}
