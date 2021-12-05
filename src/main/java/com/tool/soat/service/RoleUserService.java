package com.tool.soat.service;


import com.tool.soat.entity.SoatUsersRoles;

public interface RoleUserService {

    public void insertUserRole(Integer uId, Integer rId);
    public void removeUserRole(SoatUsersRoles soatUsersRoles);
    public String currentRole(Integer uid);
    void cCurrentRole(Integer uId, Integer rId);
}
