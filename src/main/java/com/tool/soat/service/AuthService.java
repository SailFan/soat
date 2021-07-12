package com.tool.soat.service;

import org.springframework.stereotype.Service;

/**
 * @Description:
 * @Author: Sail
 * @CreateTime: 2021/6/27 5:48 下午
 * @File: Auth
 * @Software: IntelliJIDEA
 */

public interface AuthService {
    void checkLogin(String username, String passowrd,Boolean rememberMe) throws Exception;
}
