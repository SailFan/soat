package com.tool.soat.service.impl;

import com.tool.soat.entity.SoatNav;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;



@RunWith(SpringRunner.class)
@SpringBootTest
class NavServiceImplTest {
    @Resource
    NavServiceImpl aavServiceImpl;


    @Test
    void queryNavS() {
        List<Object> objects = Collections.singletonList(aavServiceImpl.queryNavS());
//        for (SoatNav s : objects){
//            System.out.println(s);

    }
}