import com.service.UserServiceImpl;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class UserTest {
    public static void main(String[] args) {
//        //用户实际调用的是业务层，dao层不需要接触
//       UserService userService= new UserServiceImpl();
//       ((UserServiceImpl) userService).setUserDao(new UserDaoMysqlImpl());
//       userService.getUser();

        //获取ApplicationContext
        //拿到容器
        ApplicationContext context= new ClassPathXmlApplicationContext("ApplicationContext.xml");
        UserServiceImpl userServiceImpl= (UserServiceImpl) context.getBean("UserServiceImpl");

        userServiceImpl.getUser();


    }
}
