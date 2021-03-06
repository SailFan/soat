package com.tool.soat.dao;

import com.tool.soat.entity.SoatRoles;
import com.tool.soat.entity.SoatUsers;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;
import java.util.List;

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
    @org.junit.Test
    public void queryPageUser() throws Exception{
//        SoatRoles soatRoles = soatUsersMapper.queryRolesByUser(2);
//        System.out.println(soatRoles);

    }

    @Test
    public void queryEmailOrPhoneOrNameD(){
        String username="系统管理员";
        String email=null;
        String phone=null;
        SoatUsers users = soatUsersMapper.queryEmailOrPhoneOrNameD(username, email, phone);
        System.out.println(users);
    }

    @Test
    public void queryUserByEmail(){
        String email="afan6203@126.com";
        SoatUsers users = soatUsersMapper.queryUserByEmail(email);
        System.out.println(users);
    }
}