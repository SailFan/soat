package com.tool.soat.dao;

import com.tool.soat.entity.SoatUsers;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;

import static org.junit.Assert.*;

/**
 * @Description:
 * @Author: Sail
 * @CreateTime: 2021/6/27 3:29 下午
 * @File: SoatUsersMapperTest
 * @Software: IntelliJIDEA
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class SoatUsersMapperTest {

    @Resource
    private SoatUsersMapper soatUsersMapper;

    @org.junit.Test
    public void queryUserByUsername() throws Exception{
        SoatUsers user = soatUsersMapper.queryUserByUsername("zhangchen");
        System.out.println(user);

    }
}