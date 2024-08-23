# 问题1.没有bean
Caused by: org.springframework.beans.factory.NoSuchBeanDefinitionException: No qualifying bean of type 'com.service.BookService' available: expected at least 1 bean which qualifies as autowire candidate. Dependency annotations: {@org.springframework.beans.factory.annotation.Autowired(required=true), @org.springframework.beans.factory.annotation.Qualifier(value=BookServiceImpl)}

## 排错步骤:
    1.查看这个bean注入是否成功!      ok
    2. Junit单元测试，看我们的代码是否能够查询出来结果!（写test）     ok
    3.问题，一定不在我们的底层，是spring出了问题
    4.SpringMVC，整合的时候没调用到我们的service层的bean;
        4.1. applicationContext . xml没有注入bean
        4.2. web. xm1中，我们也绑定过配置文件!
            发现问题，我们配置的是Spring -mvc . xm1，这里面确实没有service bean
            所以报空指针异常





