package com.tool.soat.dao;

import com.tool.soat.common.util.OkHttpUtils;
import com.tool.soat.entity.SoatPermission;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;

import java.util.List;
import java.util.Set;

import static org.junit.Assert.*;

/**
 * @Description:
 * @Author: Sail
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
        String async = OkHttpUtils.builder()
                .url("http://www.baidu.com")
                .get()
                .async();
        System.out.println("async:" + async);

    }
}