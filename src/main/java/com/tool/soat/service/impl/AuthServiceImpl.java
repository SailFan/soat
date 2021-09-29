package com.tool.soat.service.impl;

import com.tool.soat.service.AuthService;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.stereotype.Service;

import java.util.Map;

/**
 * @Description:
 * @Author: Sail
 * @CreateTime: 2021/6/27 5:54 下午
 * @File: AuthServiceImpl
 * @Software: IntelliJIDEA
 */
@Service
public class AuthServiceImpl implements AuthService {


    public void checkLogin(String username, String passowrd) throws Exception {
        Subject subject = SecurityUtils.getSubject();
        UsernamePasswordToken token = new UsernamePasswordToken(username, passowrd);
//        token.setRememberMe(rememberMe);
        subject.login(token);
    }

}
