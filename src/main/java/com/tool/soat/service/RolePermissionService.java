package com.tool.soat.service;

import com.tool.soat.entity.SoatRoles;
import com.tool.soat.entity.SoatRolesPermissions;

import java.util.List;

public interface RolePermissionService {
    public void roleRelationPermission(Integer rid, List<Integer> pid);
    public void removeRP(Integer rid, Integer pid);

}
