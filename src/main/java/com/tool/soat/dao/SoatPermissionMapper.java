package com.tool.soat.dao;

import com.tool.soat.entity.SoatPermission;

import java.util.Set;

public interface SoatPermissionMapper {

    int insert(SoatPermission record);
    int insertSelective(SoatPermission record);
    Set<SoatPermission> queryPermissionByUsername(String username);
}