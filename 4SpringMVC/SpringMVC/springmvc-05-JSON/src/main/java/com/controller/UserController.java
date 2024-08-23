package com.controller;

import Utils.JsonUtils;
import com.alibaba.fastjson.JSON;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.pojo.User;
import com.sun.xml.internal.ws.developer.SerializationFeature;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.logging.SimpleFormatter;

//@RestController  //标记了这个，返回字符串，不走视图解析器 RestController=Controller+ResponseBody
@Controller
public class UserController {

//    @RequestMapping(value = "/user",produces = "application/json;charset=utf-8")
////    @RequestMapping(value = "/user")
//    @ResponseBody  //不会走视图解析器。会直接返回一个字符串
//    public String json1() throws JsonProcessingException {
//        //jackson, objectMapper
//        ObjectMapper mapper=new ObjectMapper();
//
//        List<User> users=new ArrayList<User>();
//
//        //创建一个对象
//        User user1=new User(1,"张三","123456");
//        User user2=new User(2,"李四","123");
//        User user3=new User(3,"王五","111");
//        User user4=new User(4,"陈留","222");
//
//        users.add(user1);
//        users.add(user2);
//        users.add(user3);
//        users.add(user4);
//
//        //把字符串转变为json形式
//        String str=mapper.writeValueAsString(users);
//        return str;
//    }


    @RequestMapping(value = "/user/2")
    @ResponseBody  //不会走视图解析器。会直接返回一个字符串
    public String json2() throws JsonProcessingException {
        //jackson, objectMapper
        ObjectMapper mapper=new ObjectMapper();

        Date date=new Date();

        //使用纯java解决
        SimpleDateFormat simpleDateFormat=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

        //把字符串转变为json形式

        return mapper.writeValueAsString(simpleDateFormat.format(date));
    }


//    ============================================================================
    //利用封装思想

//    @RequestMapping(value = "/user/3",produces = "application/json;charset=utf-8")
//    @RequestMapping(value = "/user")
//    @ResponseBody  //不会走视图解析器。会直接返回一个字符串
//    public String json3() throws JsonProcessingException {
//        List<User> users=new ArrayList<User>();
//
//        //创建一个对象
//        User user1=new User(1,"张三","123456");
//        User user2=new User(2,"李四","123");
//        User user3=new User(3,"王五","111");
//        User user4=new User(4,"陈留","222");
//
//        users.add(user1);
//        users.add(user2);
//        users.add(user3);
//        users.add(user4);
//
//        return JsonUtils.getJson(users);
//    }


    @RequestMapping(value = "/user/4")
    @ResponseBody  //不会走视图解析器。会直接返回一个字符串
    public String json4() throws JsonProcessingException {
        Date date=new Date();

        return JsonUtils.getJson(date);
    }

    @RequestMapping(value = "/user/5",produces = "application/json;charset=utf-8")
    @ResponseBody
    public String fastjson1() throws JsonProcessingException {
        List<User> users=new ArrayList<User>();

        //创建一个对象
        User user1=new User(1,"张三","123456");
        User user2=new User(2,"李四","123");
        User user3=new User(3,"王五","111");
        User user4=new User(4,"陈留","222");

        users.add(user1);
        users.add(user2);
        users.add(user3);
        users.add(user4);

        String str=JSON.toJSONString(users);
        return str;
    }

}
