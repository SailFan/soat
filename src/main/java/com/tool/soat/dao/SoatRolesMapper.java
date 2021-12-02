package com.tool.soat.dao;

import com.tool.soat.entity.SoatRoles;

import java.util.List;
import java.util.Set;

public interface SoatRolesMapper {

    int insert(SoatRoles record);

    void updateRole(String roleName, Integer rid);

    int insertSelectiveRole(SoatRoles record);

    Set<String> queryRoleNameByUsernames(String username);

    List<SoatRoles> queryAllRolePermission();

    void removeRole(Integer rid);

    SoatRoles queryRoleById(Integer rid);

    List<Integer> queryPermissionByRoleId(Integer rid);
}