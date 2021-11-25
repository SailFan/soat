package com.tool.soat.service.impl;

import com.tool.soat.dao.SoatRolesPermissionsMapper;
import com.tool.soat.entity.SoatRolesPermissions;

import com.tool.soat.service.RolePermissionService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;


@Service
public class RolePermissionServiceImpl implements RolePermissionService {
    @Resource
    SoatRolesPermissionsMapper soatRolesPermissionsMapper;

    public Integer roleRelationPermission(SoatRolesPermissions soatRolesPermissions){
        int insertOneRP = soatRolesPermissionsMapper.insertOneRP(soatRolesPermissions);
        return insertOneRP;
    }

    public void removeRP(Integer rid, Integer pid){
        soatRolesPermissionsMapper.deleteRelationByRidAndByPid(rid,pid);
    }
}
