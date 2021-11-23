package com.tool.soat.dao;

import com.tool.soat.entity.SoatRolesPermissions;

public interface SoatRolesPermissionsMapper {

    int insertOneRP(SoatRolesPermissions record);

    int insertSelective(SoatRolesPermissions record);

    void deleteRelationByRidAndByPid(SoatRolesPermissions record);


}