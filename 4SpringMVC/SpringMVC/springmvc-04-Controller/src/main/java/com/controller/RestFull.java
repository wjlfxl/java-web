package com.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;


@Controller
public class RestFull {
    //原来的: http://localhost:8080/add?a=1&b=2
    //RestFul : http://localhost:8080/add/1/2   传入ab的值

    //@RequestMapping("/add/{a}/{b}")  路径
    //@RequestMapping(value = "/add/{a}/{b}",method = RequestMethod.GET)  //后面指定访问类型GET
    //可以精简为@GetMapping("/add/{a}/{b}") //每一个方法都有一个自己的mapper
    //网址路径
    @GetMapping("/add/{a}/{b}")
    public String test1(@PathVariable int a,@PathVariable String b,Model model){
        String res=a+b;

        model.addAttribute("msg","结果为"+res);

        //jsp的页面
        return "test";
    }
}
