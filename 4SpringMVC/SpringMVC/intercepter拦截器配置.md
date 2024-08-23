# 拦截器要在application里配置
```xml
<!-- 配置拦截器-->
    <mvc:interceptors>
        <mvc:interceptor>
            <!--包括这个请求下面的所有请求-->
            <mvc:mapping path="/**"/>
            <bean class="com.lin.config.MyInterceptor"/>
        </mvc:interceptor>

        <mvc:interceptor>
            <!--包括这个请求下面的所有请求-->
            <mvc:mapping path="/user/**"/>
            <bean class="com.lin.config.LoginInterceptor"/>
        </mvc:interceptor>
    </mvc:interceptors>
```
# 拦截器类要继承HandlerInterceptor
```java
public class MyInterceptor implements HandlerInterceptor {
    //return：true；执行下一个拦截器，放行
    //
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        System.out.println("========处理前========");
        return true;
    }
    //日志
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
        System.out.println("========处理后========");
    }

    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
        System.out.println("========清理========");
    }
}
```




