package com.tool.soat.dao;

import com.tool.soat.entity.SoatRoles;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;

import java.util.Collections;
import java.util.List;
import java.util.Set;

import static org.junit.Assert.*;

/**
 * @Description:
 * @Author: Sail
 * @CreateTime: 2021/6/27 4:18 下午
 * @File: SoatRolesMapperTest
 * @Software: IntelliJIDEA
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class SoatRolesMapperTest {
    @Resource
    SoatRolesMapper soatRolesMapper;

    @Test
    public void queryRoleNameByUsernames() throws Exception{
        Set<String> set = soatRolesMapper.queryRoleNameByUsernames("zhangchen");
        System.out.println(set);

    }

    @Test
    public void queryAllRolePermission() throws Exception{
        List<SoatRoles> roles = soatRolesMapper.queryAllRolePermission();
        for (SoatRoles role: roles) {
            System.out.println(role);
        }


    }
}