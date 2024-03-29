package com.tool.soat.service.impl;

import com.tool.soat.dao.SoatUsersMapper;

import com.tool.soat.entity.SoatUsers;
import com.tool.soat.service.AuthService;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.stereotype.Service;


import javax.annotation.Resource;

import java.util.List;


/**
 * @Description:
 * @Author: 凡子
 * @CreateTime: 2021/6/27 5:54 下午
 * @File: AuthServiceImpl
 * @Software: IntelliJIDEA
 */
@Service
public class AuthServiceImpl implements AuthService {

    @Resource
    SoatUsersMapper soatUsersMapper;
    public void checkLogin(String username, String passowrd) throws Exception {
        Subject subject = SecurityUtils.getSubject();
        UsernamePasswordToken token = new UsernamePasswordToken(username, passowrd);
//        token.setRememberMe(rememberMe);
        subject.login(token);
    }

    public List<SoatUsers> queryBySizeAndNumS(Integer pagesize, Integer pagenum,String username) {
        pagenum=pagenum-1;
        List<SoatUsers> users = soatUsersMapper.queryAllUserBySizeAndNum(pagesize, pagenum,username);
        return  users;
    }

    public int insertUser(SoatUsers soatUsers) {
        soatUsers.setSalt("soat");
        int insert = soatUsersMapper.insertSelective(soatUsers);
        return insert;
    }

    public SoatUsers queryEmailOrPhone (String email, String phone) {
        SoatUsers soatUsers = soatUsersMapper.queryEmailOrPhoneD(email, phone);
        return soatUsers;
    }

    public SoatUsers selectByPrimaryKeyS(Integer id){
        SoatUsers users = soatUsersMapper.selectByPrimaryKey(id);
        return users;
    }

    public void changeStatus(Integer id) {
        SoatUsers users = soatUsersMapper.selectByPrimaryKey(id);
        users.setStatus(!users.getStatus());
        soatUsersMapper.updateByPrimaryKey(users);
    }

    public SoatUsers queryEmailOrPhoneOrNameS(String username, String email, String phone){
        SoatUsers users = soatUsersMapper.queryEmailOrPhoneOrNameD(username, email, phone);
        return users;
    }

    @Override
    public SoatUsers queryEmail(String email) {
        SoatUsers users = soatUsersMapper.queryUserByEmail(email);
        return users;
    }

    public  Integer deleteByPrimaryKey(Integer id){
        int deleteByPrimaryKey = soatUsersMapper.deleteByPrimaryKey(id);
        return deleteByPrimaryKey;
    }

    public SoatUsers queryUserS(Integer id){
        SoatUsers users = soatUsersMapper.queryUserD(id);
        return users;
    }

    public Integer modificationUserS(SoatUsers soatUsers){
        int status = soatUsersMapper.updateByPrimaryKeySelective(soatUsers);
        return status;
    }

    @Override
    public SoatUsers queryUsernameAndPassword(String email, String password) {
        SoatUsers users = soatUsersMapper.queryUAndP(email, password);
        return users;
    }


}
