package com.tool.soat.dao;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;

import java.util.Set;

/**
 * @Description:
 * @Author: 凡子
 * @CreateTime: 2021/6/27 4:36 下午
 * @File: SoatPermissionMapperTest
 * @Software: IntelliJIDEA
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class SoatPermissionMapperTest {

    @Resource
    SoatPermissionMapper soatPermissionMapper;


    @Test
    public void test1(){
        Set<String> set = soatPermissionMapper.queryAllPermissions();

    }

    @Test
    public void test2(){
//        String async = OkHttpUtils.builder()
//                .url("http://www.baidu.com")
//                .get()
//                .async();
//        System.out.println("async:" + async);

    }
}