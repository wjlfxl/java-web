package com.config;

import com.pojo.User;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

//这个也会Spring容器托管，注册到容器中,因为他本来就是一 个@Component
// @Configuration代表这是一 个配置类，就和我们之前看的beans.xmL
@Configuration
@ComponentScan("com.pojo")
@Import(MyConfig2.class)
public class MyConfig {

    //注册一-个bean ，就相当 于我们之前写的一个bean标签 id=getUser,class是返回值User
    @Bean
    public User getUser(){
        return new User();
    }
}
