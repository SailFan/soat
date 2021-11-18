package com.tool.soat.shiro;

import com.tool.soat.dao.SoatPermissionMapper;
import com.tool.soat.dao.SoatRolesMapper;
import com.tool.soat.dao.SoatUsersMapper;
import com.tool.soat.entity.SoatUsers;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.util.ByteSource;

import javax.annotation.Resource;
import java.util.Set;

/**
 * @Description:
 * @Author: Sail
 * @CreateTime: 2021/6/27 5:00 下午
 * @File: SoatRealm
 * @Software: IntelliJIDEA
 */
public class SoatRealm extends AuthorizingRealm {

    @Resource
    SoatUsersMapper soatUsersMapper;
    @Resource
    SoatRolesMapper soatRolesMapper;
    @Resource
    SoatPermissionMapper soatPermissionMapper;



    @Override
    public String getName() {
        return "soatRealm";
    }

    /***
     * 为授权器提供授权数据
     * @param principalCollection
     * @return
     */
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {
        String username =(String) principalCollection.iterator().next();
        Set<String> roleSet = soatRolesMapper.queryRoleNameByUsernames(username);
//        Set<String> permissionSet = soatPermissionMapper.queryPermissionByUsername(username);
        SimpleAuthorizationInfo authorizationInfo = new SimpleAuthorizationInfo();
        authorizationInfo.setRoles(roleSet);
//        authorizationInfo.setStringPermissions(permissionSet);
        return authorizationInfo;
    }

    /**
     * 从数据库查询到用户的正确数据,为认证器提供认证数据
     * @param authenticationToken
     * @return
     * @throws AuthenticationException
     */
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authenticationToken) throws AuthenticationException {
        UsernamePasswordToken token = (UsernamePasswordToken) authenticationToken;
        String nickname = token.getUsername();
        SoatUsers soatUsers = soatUsersMapper.queryUserByUsername(nickname);
        if (soatUsers==null){
            return null;
        }
        SimpleAuthenticationInfo info = new SimpleAuthenticationInfo(
                nickname,
                soatUsers.getPassword(),
                ByteSource.Util.bytes(soatUsers.getSalt()),
                getName()
        );

        return info;
    }
}
