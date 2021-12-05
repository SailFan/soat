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
//        soatUsersRolesMapper.deleteSoatUsersRoles(soatUsersRoles);
        soatUsersRolesMapper.insert(soatUsersRoles);
    }

    @Override
    public String currentRole(Integer uid) {
        String s = soatUsersRolesMapper.queryCurrentRole(uid);
        return s;
    }

    public void removeUserRole(SoatUsersRoles soatUsersRoles){

    }
    public void cCurrentRole(SoatUsersRoles soatUsersRoles){
        soatUsersRolesMapper.changeCurrentRole(soatUsersRoles);
    }

}
