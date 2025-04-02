package com.plctest.securitydemo.controller;

import com.plctest.securitydemo.entity.TUser;
import com.plctest.securitydemo.service.UserService;
import com.plctest.securitydemo.util.LoginInfoUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;

//@RestController
//@RequestMapping("")
//@Controller
public class UserController {
//    @Autowired
//    UserService userService;

    @GetMapping("/")
    @ResponseBody
    public String hello(){

        return "Hello";

    }

    //设置自定义登录页面
    @GetMapping("/login")
    public String login() {
        return "login"; // 返回你的登录页面视图名称
    }

//    @PostMapping("/register")
//    @ResponseBody
//    public String register(TUser user){
//        userService.insert(user);
//        return "注册成功";
//    }
    //返回当前登录用户信息方式1，使用Principal
    @RequestMapping("/welcom1")
    public @ResponseBody Object getUserInfo1(Principal principal){
        return principal;
    }
    //返回当前登录用户信息方式2
    @RequestMapping("/welcome2")
    public @ResponseBody Object getUserInfo2(){
        return LoginInfoUtil.getCurrentLoginUserInfo();
    }
}
