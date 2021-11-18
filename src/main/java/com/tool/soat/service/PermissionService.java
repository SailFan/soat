package com.tool.soat.service;

import java.util.List;
import java.util.Set;

public interface PermissionService {
   Set<String> queryCurrentPermission(String nickname);
}
