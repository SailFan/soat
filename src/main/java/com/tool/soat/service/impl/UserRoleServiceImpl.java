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

    public void insertUserRole(Integer uId, Integer rId){
        soatUsersRolesMapper.deleteSoatUsersRoles(uId,rId);
        System.out.println("uid"+uId);
        System.out.println("rId"+rId);
        soatUsersRolesMapper.insert(uId,rId);
    }

    @Override
    public String currentRole(Integer uid) {
        String s = soatUsersRolesMapper.queryCurrentRole(uid);
        return s;
    }

    public void removeUserRole(SoatUsersRoles soatUsersRoles){

    }
    public void cCurrentRole(Integer uId, Integer rId){
        soatUsersRolesMapper.changeCurrentRole(uId, rId);
    }

}
