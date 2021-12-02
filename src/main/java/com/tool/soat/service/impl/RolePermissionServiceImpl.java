package com.tool.soat.service.impl;

import com.tool.soat.dao.SoatRolesMapper;
import com.tool.soat.dao.SoatRolesPermissionsMapper;
import com.tool.soat.entity.SoatRolesPermissions;

import com.tool.soat.service.RolePermissionService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
import java.util.Set;


@Service
public class RolePermissionServiceImpl implements RolePermissionService {
    @Resource
    SoatRolesPermissionsMapper soatRolesPermissionsMapper;

    @Resource
    SoatRolesMapper soatRolesMapper;

    public void roleRelationPermission(Integer rid, List<Integer> pid){
        List<Integer> list = soatRolesMapper.queryPermissionByRoleId(rid);
        pid.removeAll(list);
        for (Integer item: pid) {
            soatRolesPermissionsMapper.insertOneRP(rid, item);
        }
    }

    public void removeRP(Integer rid, Integer pid){
        soatRolesPermissionsMapper.deleteRelationByRidAndByPid(rid,pid);
    }
}
