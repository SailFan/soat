package com.tool.soat.service;


import com.tool.soat.entity.SoatUsersRoles;

public interface RoleUserService {

    public void insertUserRole(SoatUsersRoles soatUsersRoles);
    public void removeUserRole(SoatUsersRoles soatUsersRoles);
}