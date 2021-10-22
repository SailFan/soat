package com.tool.soat.service.impl;

import com.tool.soat.entity.SoatUsers;
import com.tool.soat.service.AuthService;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.util.DigestUtils;

import javax.annotation.Resource;

import java.io.UnsupportedEncodingException;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;


@RunWith(SpringRunner.class)
@SpringBootTest
class AuthServiceImplTest {
    @Resource
    AuthService authService;

    @Test
    void checkLogin() {
    }

    @Test
    void queryBySizeAndNumS() {
        List<SoatUsers> users = authService.queryBySizeAndNumS(5, 1, null, null, "13893887430");
        System.out.println(users);
    }

    @Test
    void insertUser() throws UnsupportedEncodingException {
        SoatUsers users = new SoatUsers();
        users.setUsername("用户五");
        users.setSalt("soat");
        users.setNickname("test");
        users.setEmail("m17600576201@163.com");
        users.setRole("qa");
        String hex = DigestUtils.md5DigestAsHex("soat123456".getBytes());
        users.setPhone("17600576201");
        users.setPassword(hex);
        users.setStatus(Boolean.TRUE);

        int i = authService.insertUser(users);
        System.out.println(i);
    }
}