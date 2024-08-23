##1.在pom.xml先导入log4j的包
```xml
<dependency>
            <groupId>log4j</groupId>
            <artifactId>log4j</artifactId>
            <version>1.2.12</version>
        </dependency>
```
    
=========================================================================
##2.在resources里配置log4j.properties
将等级为DEBUG的日志信息输出到console和file这两个目的地，console和file的定义在下面的代码
```xml
log4j.rootLogger=DEBUG,console,file

#控制台输出的相关设置
log4j.appender.console = org.apache.log4j.ConsoleAppender
log4j.appender.console.Target = System.out
log4j.appender.console.Threshold=DEBUG
log4j.appender.console.layout = org.apache.log4j.PatternLayout
log4j.appender.console.layout.ConversionPattern=【%c】-%m%n

#文件输出的相关设置
log4j.appender.file = org.apache.log4j.RollingFileAppender
log4j.appender.file.File=./log/com.log
log4j.appender.file.MaxFileSize=10mb
log4j.appender.file.Threshold=DEBUG
log4j.appender.file.layout=org.apache.log4j.PatternLayout
log4j.appender.file.layout.ConversionPattern=【%p】【%d{yy-MM-dd}】【%c】%m%n

#日志输出级别
log4j.logger.org.mybatis=DEBUG
log4j.logger.java.sql=DEBUG
log4j.logger.java.sql.Statement=DEBUG
log4j.logger.java.sql.ResultSet=DEBUG
log4j.logger.java.sql.PreparedStatement=DEBUG


```

##3.mybatis-config.xml里写
```xml
    <settings>
<!--        <setting name="logImpl" value="STDOUT_LOGGING"/>-->
        <setting name="logImpl" value="LOG4J"/>
    </settings>
```

#使用Log4j
##1.在要使用Log4j的类中，导入包 
```java
import org.apache.log4j.Logger;
```

===========================================================
##2.在测试类中，创建日志对象，参数为当前类的class
```java
static Logger logger = Logger.getLogger(UserMapperTest.class);
```

##3.创建一个log4j方法
```java
    @Test
    public void testLog4j(){
        logger.info("info:进入了log4j方法");
        logger.debug("debug:进入了log4j方法");
        logger.error("error:进入了log4j方法");
    }
```

