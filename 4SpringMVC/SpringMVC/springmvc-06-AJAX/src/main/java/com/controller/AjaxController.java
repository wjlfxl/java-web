package com.controller;

import com.pojo.User;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@RestController
public class AjaxController {

    @RequestMapping("/t1")
    public String test(){
        return "hello";
    }


    @RequestMapping("/a1")
    public void a1(String name, HttpServletResponse response) throws IOException {
//        System.out.println("a1:param==>"+name);
        if ("www".equals(name)){
            response.getWriter().println("true");
        }
        else{
            response.getWriter().println("false");
        }
    }


    @RequestMapping("/a2")
    public List<User> a2(){
        List<User> userList = new ArrayList<User>();
        //添加数据
        userList.add(new User("张三",18,"男"));
        userList.add(new User("李四",18,"女"));
        userList.add(new User("王五",18,"男"));


        return userList; //由于@RestController注解，将list转成json格式返回
    }

    @RequestMapping("/a3")
    public String ajax3(String name,String pwd){
        String msg = "";
        //模拟数据库中存在数据
        if (name!=null){
            if ("admin".equals(name)){
                msg = "OK";
            }else {
                msg = "用户名输入错误";
            }
        }
        if (pwd!=null){
            if ("123456".equals(pwd)){
                msg = "OK";
            }else {
                msg = "密码输入有误";
            }
        }
        return msg; //由于@RestController注解，将msg转成json格式返回
    }

    @RequestMapping("/a4")
    public String ajax4(String name,String pwd){
        String msg = "";
        //模拟数据库中存在数据
        if (name!=null & pwd!=null){
            if ("admin".equals(name) & "123456".equals(pwd)){
                msg = "OK";
            }else {
                msg = "用户名密码输入错误";
            }
        }

        return msg; //由于@RestController注解，将msg转成json格式返回
    }

}
