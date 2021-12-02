package com.tool.soat.dao;

import com.tool.soat.entity.SoatRolesPermissions;

public interface SoatRolesPermissionsMapper {

    int insertOneRP(Integer rid, Integer item);

    int insertSelective(SoatRolesPermissions record);

    void deleteRelationByRidAndByPid(Integer rid, Integer pid);


}