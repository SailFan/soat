package com.tool.soat.controller;

import com.tool.soat.common.vo.R;
import com.tool.soat.common.vo.RHttpStatusEnum;
import com.tool.soat.service.AuthService;
import org.apache.shiro.crypto.hash.Md5Hash;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.Map;


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


    @RequestMapping(value = "/login", method = RequestMethod.POST,consumes="application/json")
    public R login(@RequestBody Map<String,Object> map){
        String username= (String) map.get("username");
        String password= (String) map.get("password");
        try {
            authService.checkLogin(username,password);
            return new R(RHttpStatusEnum.LOGIN_SUCCESS.getCode(), "",RHttpStatusEnum.LOGIN_SUCCESS.getMessage());
        } catch (Exception e) {
            e.printStackTrace();
            return new R(RHttpStatusEnum.LOGIN_FAIL.getCode(), "",RHttpStatusEnum.LOGIN_FAIL.getMessage());
        }

    }

    @RequestMapping("/regist")
    public String regist(String username, String password){
        Md5Hash md5Hash = new Md5Hash(password,"soat");
        System.out.println(md5Hash);
        return "111";
    }

}
