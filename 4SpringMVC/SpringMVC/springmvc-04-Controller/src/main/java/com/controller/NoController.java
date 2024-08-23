package com.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

//非正常是方式--不需要视图解析器（要把xml里的视图解析器注释掉）（不推荐）
@Controller
public class NoController {

    //加全路径名--转发的方式
    @RequestMapping("/test/1")
    public String test1(Model model){
        model.addAttribute("msg","test1");
        //jsp的页面
        return "/WEB-INF/jsp/test.jsp";
    }

    //全路径名
    @RequestMapping("/test/2")
    public String test2(Model model){
        model.addAttribute("msg","test2");
        //jsp的页面
        return "forward:/WEB-INF/jsp/test.jsp";
    }

    //重定向
    //重定向无法访问WEB-INF下的文件
    @RequestMapping("/test/3")
    public String test3(){
        //jsp的页面
        return "redirect:/index.jsp";
    }

}
