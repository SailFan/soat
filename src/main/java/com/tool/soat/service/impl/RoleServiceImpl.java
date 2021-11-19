package com.tool.soat.service.impl;

import com.tool.soat.dao.SoatRolesMapper;
import com.tool.soat.dao.SoatSetMapper;
import com.tool.soat.entity.SoatRoles;
import com.tool.soat.entity.SoatSet;
import com.tool.soat.service.RoleService;
import com.tool.soat.service.SetService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Date;
import java.util.List;

@Service
public class RoleServiceImpl implements RoleService {

    @Resource
    SoatRolesMapper soatRolesMapper;
    public List<SoatRoles> queryAllRolePer(){
        List<SoatRoles> roles = soatRolesMapper.queryAllRolePermission();
        return roles;
    }

    public Integer insertRole(SoatRoles soatRoles){
        int i = soatRolesMapper.insertSelectiveRole(soatRoles);
        return i;
    }

    public void updateCurrentRole(SoatRoles soatRoles){
        soatRolesMapper.updateRole(soatRoles.getRoleName(), soatRoles.getRid());
    }
}
