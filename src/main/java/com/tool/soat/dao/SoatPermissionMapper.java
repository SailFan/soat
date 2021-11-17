package com.tool.soat.dao;

import com.tool.soat.entity.SoatPermission;

public interface SoatPermissionMapper {

    int insert(SoatPermission record);
    int insertSelective(SoatPermission record);

}