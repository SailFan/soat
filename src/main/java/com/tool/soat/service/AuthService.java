package com.tool.soat.service;

import com.tool.soat.entity.SoatUsers;

import java.util.List;

/**
 * @Description:
 * @Author: Sail
 * @CreateTime: 2021/6/27 5:48 下午
 * @File: Auth
 * @Software: IntelliJIDEA
 */

public interface AuthService {
    void checkLogin(String username, String passowrd) throws Exception;
    int insertUser(SoatUsers soatUsers);
    List<SoatUsers> queryBySizeAndNumS(Integer pagesize, Integer pagenum,String username, String email, String phone);
    SoatUsers queryEmailOrPhone (String email, String phone);
    SoatUsers selectByPrimaryKeyS(Integer id);
    void changeStatus(Integer id);
    SoatUsers queryEmailOrPhoneOrNameS(String username, String email, String phone);
}
