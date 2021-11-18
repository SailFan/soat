package com.tool.soat.service.impl;

import com.tool.soat.dao.SoatPermissionMapper;
import com.tool.soat.dao.SoatRolesMapper;
import com.tool.soat.entity.SoatPermission;
import com.tool.soat.service.PermissionService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;

import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;


@RunWith(SpringRunner.class)
@SpringBootTest
public class PermissionServiceImplTest {
    @Resource
    PermissionService permissionService;

    @Test
    public void test1(){
        Set<SoatPermission> admin = permissionService.queryCurrentPermission("admin");
        System.out.println(admin);
    }

}