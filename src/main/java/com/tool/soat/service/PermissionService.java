package com.tool.soat.service;

import com.tool.soat.entity.SoatPermission;
import com.tool.soat.entity.SoatSet;

import java.util.List;
import java.util.Set;

public interface PermissionService {
   Set<SoatPermission> queryCurrentPermission(String nickname);
}
