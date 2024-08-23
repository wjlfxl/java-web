# JSON
### JSON是JavaScript对象的字符串表示法，它使用文本表示一个JS对象的信息,本质是一个字 符串。
#### 前端示例
```html
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>$Title$</title>

    <%--JSON是JavaScript对象的字符串表示法，它使用文本表示一个JS对象的信息,本质是一个字 符串。--%>

    <script type="text/javascript">
        var user={
            name:"张三",
            age:5,
            sex:"男"
        }
        console.log(user);

        //将js转换成json对象
        var json=JSON.stringify(user);
        console.log(json);

        //将JSON对象转换成js对象
        var js=JSON.parse(json);
        console.log(js);
    </script>
</head>
<body>
$END$
</body>
</html>
```

# 正式开始
## 前两步先完成mvc基本配置（先前导的包不再展示了）
## 1.springmvc基础配置web.xml
```xml
<servlet>
        <servlet-name>springmvc</servlet-name>
        <servlet-class>org.springframework.web.servlet.DispatcherServlet</servlet-class>
        <init-param>
            <param-name>contextConfigLocation</param-name>
            <param-value>classpath:springmvc-servlet.xml</param-value>
        </init-param>
        <load-on-startup>1</load-on-startup>
    </servlet>
    <!--     / 只匹配所有的请求，不会去匹配jsp页面-->
    <!--    /* 匹配所有的请求，包括jsp. 页面-->
    <servlet-mapping>
        <servlet-name>springmvc</servlet-name>
        <url-pattern>/</url-pattern>
    </servlet-mapping>

    <filter>
        <filter-name>encoding</filter-name>
        <filter-class>org.springframework.web.filter.CharacterEncodingFilter</filter-class>
        <init-param>
            <param-name>encoding</param-name>
            <param-value>utf-8</param-value>
        </init-param>
    </filter>
    <filter-mapping>
        <filter-name>encoding</filter-name>
        <url-pattern>/*</url-pattern>
    </filter-mapping>
```

## 2.springmvc基础配置resources里的springmvc-servlet.xml
```xml
 <!--    用注解开发不需要处理映射器，处理器适配器-->
<!--    自动扫描包，让指定包下的注解生效,由IOC容器统一管理-->
    <context:component-scan base-package="com.controller"/>

<!--    让Spring MVC不处理静态资源 .Css .js .htmL .mp3 . mp4 &ndash;&gt;-->
    <mvc:default-servlet-handler/>

    <mvc:annotation-driven/>

<!--    视图解析器:DispatcherServlet给他的ModelAndView-->
    <bean class="org.springframework.web.servlet.view.InternalResourceViewResolver" id="InternalResourceViewResolver">
        <!--前缀-->
        <property name="prefix" value="/WEB-INF/jsp/"/>
        <!--后缀-->
        <property name="suffix" value=".jsp"/>
    </bean>
```

## 3.在项目里导入JSON用的包
```xml
<dependencies>
        <dependency>
            <groupId>com.fasterxml.jackson.core</groupId>
            <artifactId>jackson-databind</artifactId>
            <version>2.10.0</version>
        </dependency>
    </dependencies>
```

#### ---------------------
## 4.开始使用
### 4.1编写实体类user.java
```java
public class User {
    private int id;
    private String name;
    private String pwd;
    //get,set,无参，有参,tostring方法略
}
```
### 4.2编写UserController
#### 使用JSON两者方法
##### 1.在方法上加@ResponseBody
```java
@Controller
public class UserController {
    @RequestMapping(value = "/user")
    @ResponseBody  //不会走视图解析器。会直接返回一个字符串
    public String json1() {
        return null;
    }
}
```
##### 2.在类上直接加 @RestController,方法上就不用加@ResponseBody
```java
@RestController  //标记了这个，返回字符串，不走视图解析器 RestController=Controller+ResponseBody
public class UserController {
    @RequestMapping(value = "/user")
    public String json1(){
        return null;
    }
}
```

### 4.3使用json方法要走几步
    1.jackson, objectMapper
    ObjectMapper mapper=new ObjectMapper();
    
    2.创建一个对象或者其他操作

    3.把字符串转变为json形式
    String str=mapper.writeValueAsString(users);
            
    4.返回JSON字符串
     return str;

#### 具体如下
```java
@Controller
public class UserController {
    
    @RequestMapping(value = "/user")
    @ResponseBody 
    public String json1() throws JsonProcessingException {
        //1.jackson, objectMapper
        ObjectMapper mapper=new ObjectMapper();

        List<User> users=new ArrayList<User>();

        //创建一个对象
        User user1=new User(1,"张三","123456");
        User user2=new User(2,"李四","123");
        User user3=new User(3,"王五","111");
        User user4=new User(4,"陈留","222");

        users.add(user1);
        users.add(user2);
        users.add(user3);
        users.add(user4);

        //把字符串转变为json形式
        String str=mapper.writeValueAsString(users);
        return str;
    }


    @RequestMapping(value = "/user/2")
    @ResponseBody  
    public String json2() throws JsonProcessingException {
        //jackson, objectMapper
        ObjectMapper mapper = new ObjectMapper();

        Date date = new Date();

        //使用纯java解决时间格式
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

        //把字符串转变为json形式

        return mapper.writeValueAsString(simpleDateFormat.format(date));
    }
}
```

#### 解决JSON返回字符串乱码问题
#### 1.在springmvc-servlet.xml里配置
```xml
<!--    json乱码问题配置-->
    <mvc:annotation-driven>
        <mvc:message-converters>
            <bean class="org.springframework.http.converter.StringHttpMessageConverter">
                <constructor-arg value="UTF-8"/>
            </bean>
            <bean class="org.springframework.http.converter.json.MappingJackson2HttpMessageConverter">
                <property name="objectMapper">
                    <bean class="org.springframework.http.converter.json.Jackson2ObjectMapperFactoryBean">
                        <property name="failOnEmptyBeans" value="false"/>
                    </bean>
                </property>
            </bean>
        </mvc:message-converters>
    </mvc:annotation-driven>

```
#### 二，在@RequestMapping里加produces = "application/json;charset=utf-8"
```java
@RequestMapping(value = "/user",produces = "application/json;charset=utf-8")
```

## 5.利用封装思想精简代码
### 5.1使用JSON那些重复代码可以忽略
    //jackson, objectMapper
    ObjectMapper mapper = new ObjectMapper();


    //使用纯java解决时间格式
    SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

    //把字符串转变为json形式

    return mapper.writeValueAsString(simpleDateFormat.format(date));

### 5.2写一个JSON工具类JsonUtils.java
```java
public class JsonUtils {
    public static String getJson(Object object) throws JsonProcessingException {
        return JsonUtils.getJson(object,"yyyy-MM-dd HH:mm:ss");
    }

    public static String getJson(Object object, String dateFormat) throws JsonProcessingException {
        ObjectMapper mapper=new ObjectMapper();

        SimpleDateFormat sdf=new SimpleDateFormat(dateFormat);
        mapper.setDateFormat(sdf);


        try {
            return mapper.writeValueAsString(object);
        }catch (JsonProcessingException e){
            e.printStackTrace();
        }
        return null;
    }
}
```
##### 多参数的调用少参数的一环套一环

### 5.3结果
```java
//@Controller
public class UserController {
    //利用封装思想
    @RequestMapping(value = "/user/3",produces = "application/json;charset=utf-8")
    @ResponseBody
    public String json3() throws JsonProcessingException {
        List<User> users=new ArrayList<User>();

        //创建一个对象
        User user1=new User(1,"张三","123456");
        User user2=new User(2,"李四","123");
        User user3=new User(3,"王五","111");
        User user4=new User(4,"陈留","222");

        users.add(user1);
        users.add(user2);
        users.add(user3);
        users.add(user4);

        return JsonUtils.getJson(users);
    }


    @RequestMapping(value = "/user/4")
    @ResponseBody
    public String json4() throws JsonProcessingException {
        Date date=new Date();

        return JsonUtils.getJson(date);
    }

}

```




