#方法一
##导包
    junito 
    mybatiso 
    mysql数据库
    spring相关的
    aop织入
    mybatis-spring 【new】

```xml
    <dependency>
        <groupId>org.mybatis</groupId>
        <artifactId>mybatis-spring</artifactId>
        <version>2.0.6</version>
    </dependency>
    <!--Spring操作数据库的话，还需要一个spring-jdbc-->
    <dependency>
        <groupId>org.springframework</groupId>
        <artifactId>spring-jdbc</artifactId>
        <version>5.3.12</version>
    </dependency>
    <dependency>
        <groupId>org.aspectj</groupId>
        <artifactId>aspectjweaver</artifactId>
        <version>1.9.7</version>
    </dependency>
    <dependency>
        <groupId>org.aspectj</groupId>
        <artifactId>aspectjweaver</artifactId>
        <version>1.9.7</version>
    </dependency>
```
#
##1.在ApplicationContext.xml配置
###舍弃mybatis.xml（相应的在ApplicationContext配置类，mybatis里得删）里的配置
```xml
<!--    DataSource:使用Spring的数据源替换mybatis的配置c3p0 dbcp druid
        我们这里使用Spring提供的JDBC : org.springframework.jdbc.datasource-->

<bean id="dataSource" class="org.springframework.jdbc.datasource.DriverManagerDataSource">
    <property name="driverClassName" value="com.mysql.jdbc.Driver"/>
    <property name="url"
              value="jdbc:mysql://127.0.0.1:3306/library?useSSL=false&amp;useUnicode=true&amp;characterEncoding=UTF-8"/>
    <property name="username" value="root"/>
    <property name="password" value="123456"/>
</bean>


        <!--    sqLSessionFactory-->
<bean id="sqlSessionFactory" class="org.mybatis.spring.SqlSessionFactoryBean">
<property name="dataSource" ref="dataSource" />
<!--        绑定mybatis配置文件,把两个文件连起来了(可以完全替代mybatis.xml文件)-->
<property name="configLocation" value="classpath:mybatis-config.xml"/>
<property name="mapperLocations" value="classpath:BookMapper.xml"/>
</bean>

        <!--    SqlSessionTemplate就算是我们使用的SqlSession-->
<bean id="sqlSession" class="org.mybatis.spring.SqlSessionTemplate">
<!--只能使用构造器注入-->
<constructor-arg index="0" ref="sqlSessionFactory"/>
</bean>
```
###配置完成，util工具类不需要了
###实体类Book不变
###BookMapper接口bub
```java
public interface BookMapper {
    List<Book> getBookList();
}
```


###BookMapper.xml的sql语句不变
```xml
<?xml version="1.0" encoding="UTF-8" ?>
<!DOCTYPE mapper
        PUBLIC "-//mybatis.org//DTD Mapper 3.0//EN"
        "http://mybatis.org/dtd/mybatis-3-mapper.dtd">

<mapper namespace="com.dao.BookMapper">

    <select id="getBookList" resultType="com.bean.Book">
       select * from library.book;
    </select>
</mapper>
```


##3.新建业务类BookMapperImpl.java
###建实现sqlSession方法
```java
public class BookMapperImpl implements BookMapper{
    ////我们的所有操作，都使用sqLSession来执行，在原来，现在都使川sqLSessionTemplate;
    private SqlSessionTemplate sqlSession;

    public void setSqlSession(SqlSessionTemplate sqlSession) {
        this.sqlSession = sqlSession;
    }

    
}
```

###在BookMapperImpl.java里写
```java
@Override
    public List<Book> getBookList() {
        BookMapper mapper=sqlSession.getMapper(BookMapper.class);
        return mapper.getBookList();
    }
```

##4.测试BookTest
```java
    @Test
    public void getBookList(){
        ApplicationContext context=new ClassPathXmlApplicationContext("ApplicationContext.xml");
        BookMapper mapper=context.getBean("bookMapper",BookMapper.class);
        List<Book> books=mapper.getBookList();
        for (Book book:books){
            System.out.println(book);
        }

    }
```

#
#
#方法二
##1.精简sqlSession语句
###修改implement类
```java
public class BookMapperImpl extends SqlSessionDaoSupport implements BookMapper{

    @Override
    public List<Book> getBookList() {
        return getSqlSession().getMapper(BookMapper.class).getBookList();
    }
}
```

###2.可以删除spring-dao-setting.xml
```xml
    <!--    SqlSessionTemplate就算是我们使用的SqlSession-->
    <bean id="sqlSession" class="org.mybatis.spring.SqlSessionTemplate">
        <!--只能使用构造器注入-->
        <constructor-arg index="0" ref="sqlSessionFactory"/>
    </bean>
```

###3.修改ApplicationContext.xml
```xml
    <bean id="bookMapper" class="com.dao.BookMapperImpl">
        <property name="sqlSessionFactory" ref="sqlSessionFactory"/>
    </bean>
```

###4.测试


