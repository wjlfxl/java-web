package com.controller;

import com.pojo.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;


@Controller
public class FormController {
    @PostMapping("/form/1")
    //@RequestParam("username") 加这个注明是前端传过来的参数
    //网址上是username，实际参数是name
    public String test1(String name, Model model){
        System.out.println("name = " + name);
        model.addAttribute("msg",name);

        //jsp的页面
        return "test";
    }

}
