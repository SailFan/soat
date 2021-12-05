package com.tool.soat.dao;

import com.tool.soat.entity.SoatUsersRoles;

public interface SoatUsersRolesMapper {

    int insert(Integer uId, Integer rId);


    int insertSelective(SoatUsersRoles record);

    void deleteSoatUsersRoles(Integer uId, Integer rId);
    void changeCurrentRole(Integer uId, Integer rId);
    String queryCurrentRole(Integer uid);
}