package com.tool.soat.service;

import com.tool.soat.entity.SoatRoles;
import com.tool.soat.entity.SoatSet;

import java.util.List;

public interface RoleService {
    public List<SoatRoles> queryAllRolePer();
    public Integer insertRole(SoatRoles soatRoles);
    public void updateCurrentRole(SoatRoles soatRoles);
    public void removeRoleAllRelation(Integer rid);
}
