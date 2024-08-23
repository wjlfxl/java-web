package com.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
//@RequestMapping("/hell0") //多级路径
public class HelloController {

    @RequestMapping("/hello")//路径
    public String Hello(Model model){
        //封装数据
        model.addAttribute("msg","HelloSpringMVC Annotation");

        return "hello";
    }
}
