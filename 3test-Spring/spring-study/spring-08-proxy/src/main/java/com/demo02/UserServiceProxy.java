package com.demo02;

public class UserServiceProxy implements UserService{

    private UserServiceImpl userService;

    public void setUserService(UserServiceImpl userService) {
        this.userService = userService;
    }

    public void add() {
        log("add");
        userService.add();
    }

    public void update() {
        log("update");
        userService.update();
    }

    public void delete() {
        log("delete");
        userService.delete();
    }

    public void query() {
        log("query");
        userService.query();
    }

    public void log(String msg){
        System.out.println("[DEBUG]调用了"+msg+"方法");

    }
}
