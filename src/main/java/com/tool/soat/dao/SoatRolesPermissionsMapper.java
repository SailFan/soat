package com.tool.soat.dao;

import com.tool.soat.entity.SoatRolesPermissions;

public interface SoatRolesPermissionsMapper {

    int insertOneRP(Integer rId, Integer pId);

    int insertSelective(SoatRolesPermissions record);

    void deleteRelationByRidAndByPid(Integer rid, Integer pid);


}