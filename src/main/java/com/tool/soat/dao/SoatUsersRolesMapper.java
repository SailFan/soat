package com.tool.soat.dao;

import com.tool.soat.entity.SoatUsersRoles;

public interface SoatUsersRolesMapper {

    int insert(SoatUsersRoles record);


    int insertSelective(SoatUsersRoles record);

    void deleteSoatUsersRoles(SoatUsersRoles record);
}