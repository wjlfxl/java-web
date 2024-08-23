#面试回答：前端控制器接受用户的请求并拦截，根据对应的请求找到对应的Controller处理器，处理器调用业务层并返回信息给前端控制器，然后前端控制器调用视图解析器找到对应视图并将数据渲染

    1、客户端发出一个http请求给web服务器，web服务器对http请求进行解析，如果匹配DispatcherServlet的请求映射路径（在web.xml中指定），web容器将请求转交给DispatcherServlet.
    
    2、DipatcherServlet接收到这个请求之后将根据请求的信息（包括URL、Http方法、请求报文头和请求参数Cookie等）以及HandlerMapping的配置找到处理请求的处理器（Handler）。
    
    3-4、DispatcherServlet根据HandlerMapping找到对应的Handler,将处理权交给Handler（Handler将具体的处理进行封装），再由具体的HandlerAdapter对Handler进行具体的调用。
    
    5、Handler对数据处理完成以后将返回一个ModelAndView()对象给DispatcherServlet。
    
    6、Handler返回的ModelAndView()只是一个逻辑视图并不是一个正式的视图，DispatcherSevlet通过ViewResolver将逻辑视图转化为真正的视图View。
    
    7、Dispatcher通过model解析出ModelAndView()中的参数进行解析最终展现出完整的view并返回给客户端。

#
    2. HandlerMapping为处理器映射。DispatcherServlet调用
       HandlerMapping, Ha ndlerMapping根据请求url查找Handler。
    3. HandlerExecution表頑体的Handler,其主要作用是根据url查找控制器，如. 上url被查找控制器
       为: hello。
    4. HandlerExecution将解析后的信息传递给DispatcherServlet,如解析控制器映射等。
    5. HandlerAdapter表示处理器适配器，其按照特定的规则去执行Handler。
    6. Handler让具体的Controller执行。
    7. Controller将具体的执行信息返回给HandlerAdapter，如ModelAndView。
    8. HandlerAdapter将视图逻辑名或模型传递给DispatcherServlet。
    9. DispatcherServlet调用视图解析器(ViewResolver)来解析HandlerAda pter传递的逻辑视图
       名。
       10.视图解析器将解析的逻辑视图名传给DispatcherServlet。
    11. DispatcherServlet根据视图解析器解析的视图结果，调具体的视图。
        12.最终视图呈现给用户。
