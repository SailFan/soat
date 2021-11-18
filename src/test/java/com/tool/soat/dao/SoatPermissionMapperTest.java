package com.tool.soat.dao;

import com.tool.soat.entity.SoatPermission;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;

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
    public void queryPermissionByUsername() throws Exception {
        Set<SoatPermission> set = soatPermissionMapper.queryPermissionByUsername("admin");
        System.out.println(set);
    }
}