package com.controller;

import com.pojo.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;


@Controller
public class Controller1 {
    @GetMapping("/user/1")
    //@RequestParam("username") 加这个注明是前端传过来的参数
    //网址上是username，实际参数是name
    public String test1(@RequestParam("username") String name, Model model){
        System.out.println("name = " + name);

        model.addAttribute("msg",name);

        //jsp的页面
        return "test";
    }

    @GetMapping("/user/2")
    //@RequestParam("username") 加这个注明是前端传过来的参数
    //网址上是username，实际参数是name
    public String test2(User user){
        System.out.println(user);
        //jsp的页面
        return "test";
    }
}
