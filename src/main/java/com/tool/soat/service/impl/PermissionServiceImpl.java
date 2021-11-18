package com.tool.soat.service.impl;

import com.tool.soat.dao.SoatPermissionMapper;
import com.tool.soat.entity.SoatPermission;
import com.tool.soat.entity.SoatSet;
import com.tool.soat.service.PermissionService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
import java.util.Set;

@Service
public class PermissionServiceImpl implements PermissionService {
    @Resource
    SoatPermissionMapper soatPermissionMapper;
    public Set<SoatPermission> queryCurrentPermission(String nickname){
        Set<SoatPermission> permissions = soatPermissionMapper.queryPermissionByUsername(nickname);
        return permissions;
    }
}
