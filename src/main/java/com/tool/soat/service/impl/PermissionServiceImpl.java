package com.tool.soat.service.impl;

import com.tool.soat.dao.SoatPermissionMapper;
import com.tool.soat.service.PermissionService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Service
public class PermissionServiceImpl implements PermissionService {
    @Resource
    SoatPermissionMapper soatPermissionMapper;
    public Set<String> queryCurrentPermission(String nickname){
        Set<String> permissions = soatPermissionMapper.queryPermissionByUsername(nickname);
        permissions.removeAll(Collections.singleton(null));
        return permissions;
    }
}
