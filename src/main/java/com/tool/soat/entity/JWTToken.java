package com.tool.soat.entity;

import org.apache.shiro.authc.AuthenticationToken;

/**
 * @Description:
 * @Author: Sail
 * @CreateTime: 2022/6/19 13:10
 * @File: JWTToken
 * @Software: IntelliJIDEA
 */
public class JWTToken implements AuthenticationToken {
    // 密钥
    private String token;

    public JWTToken(String token) {
        this.token = token;
    }

    @Override
    public Object getPrincipal() {
        return token;
    }

    @Override
    public Object getCredentials() {
        return token;
    }
}
