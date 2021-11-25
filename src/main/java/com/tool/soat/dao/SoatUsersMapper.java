package com.tool.soat.dao;

import com.tool.soat.entity.SoatUsers;

import java.util.List;

public interface SoatUsersMapper {

    int deleteByPrimaryKey(Integer id);
    int insert(SoatUsers record);
    int insertSelective(SoatUsers record);
    SoatUsers selectByPrimaryKey(Integer id);
    int updateByPrimaryKeySelective(SoatUsers record);
    int updateByPrimaryKey(SoatUsers record);
    SoatUsers queryUserByUsername(String username);
    List<SoatUsers> queryAllUserBySizeAndNum(Integer pagesize, Integer pagenum,String username);
    SoatUsers queryEmailOrPhoneD(String email, String phone);
    SoatUsers queryEmailOrPhoneOrNameD(String username, String email, String phone);
    SoatUsers queryUserD(Integer id);
}