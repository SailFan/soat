package com.tool.soat.service.impl;

import com.tool.soat.entity.SoatRoles;
import com.tool.soat.entity.SoatUsers;
import com.tool.soat.service.AuthService;
import org.apache.commons.collections.CollectionUtils;
import org.apache.shiro.SecurityUtils;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.util.DigestUtils;

import javax.annotation.Resource;

import java.io.UnsupportedEncodingException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.List;

import static java.util.stream.Collectors.toList;
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
        ArrayList<Integer> list1 = new ArrayList<>();
        list1.add(1);
        list1.add(2);
        list1.add(4);
        list1.add(3);
        ArrayList<Integer> list2 = new ArrayList<>();
        list2.add(3);
        list2.add(4);
        list2.add(5);
        list2.add(6);
        List<Integer> list = list1.stream().filter(item -> list2.contains(item)).collect(toList());
        System.out.println(list);
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

    @Test
    void modificationUserS(){
        SoatUsers soatUsers = new SoatUsers();
        soatUsers.setPassword("654321");
        soatUsers.setNickname("1212");
        soatUsers.setEmail("afan6203@187.com");
        soatUsers.setPhone("11011011110");
        soatUsers.setId(3);
        Integer integer = authService.modificationUserS(soatUsers);
        System.out.println(integer);
    }

    @Test
    void testPrint(){
//        Date date = new Date();
//        DateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
//        System.out.println(df.format(date));
        SoatUsers users = (SoatUsers) SecurityUtils.getSubject().getPrincipal();

    }

    @Test
    void queryEmail(){
        SoatUsers users = authService.queryEmail("afan6203@126.com");
        System.out.println(users);
    }


    @Test
    void testMd5(){
        String base = "123456soat";
        String md5 = DigestUtils.md5DigestAsHex(base.getBytes());
        System.out.println(md5);
    }

    @Test
    void testString(){
        String base = "123456";
        String soat = "soat";
        System.out.println(base+soat);
    }


    @Test
    void queryUsernameAndPassword() {
        SoatUsers users = authService.queryUsernameAndPassword("afan6203@126.com", "a3eb67417ed506a6e7800f3236b6f85c");
        System.out.println(users);
    }



}