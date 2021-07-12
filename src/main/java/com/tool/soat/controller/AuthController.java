package com.tool.soat.controller;

import com.tool.soat.service.AuthService;
import org.apache.shiro.crypto.hash.Md5Hash;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;


@RestController
@RequestMapping("/auth")
public class AuthController {
    Logger logger = LoggerFactory.getLogger(getClass());

    @Resource
    AuthService authService;

    @RequestMapping(value = "/")
    public String index(){
        return "success";
    }

    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public String login(String username, String password,Boolean rememberMe){
        System.out.println(username);
        System.out.println(password);
        try {
            authService.checkLogin(username,password,rememberMe);
            System.out.println("登录成功");
            return "登录成功";
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("用户或者密码错误");
            return "登录失败";
        }

    }

    @RequestMapping("/regist")
    public String regist(String username, String password){
        Md5Hash md5Hash = new Md5Hash(password,"soat");
        System.out.println(md5Hash);
        return "111";
    }

}
