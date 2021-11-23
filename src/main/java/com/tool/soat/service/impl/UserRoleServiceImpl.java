package com.tool.soat.service.impl;


import com.tool.soat.dao.SoatUsersRolesMapper;
import com.tool.soat.entity.SoatUsersRoles;
import com.tool.soat.service.RoleUserService;
import org.springframework.stereotype.Service;
import javax.annotation.Resource;


@Service
public class UserRoleServiceImpl implements RoleUserService {

    @Resource
    SoatUsersRolesMapper soatUsersRolesMapper;

    public void insertUserRole(SoatUsersRoles soatUsersRoles){
        soatUsersRolesMapper.insert(soatUsersRoles);
    }
    public void removeUserRole(SoatUsersRoles soatUsersRoles){

    }
}
