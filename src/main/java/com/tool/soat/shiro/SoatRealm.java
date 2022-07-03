package com.tool.soat.shiro;

import com.auth0.jwt.exceptions.SignatureVerificationException;
import com.auth0.jwt.exceptions.TokenExpiredException;
import com.tool.soat.common.util.SoatJWTUtil;
import com.tool.soat.dao.SoatRolesMapper;
import com.tool.soat.dao.SoatUsersMapper;
import com.tool.soat.entity.JWTToken;
import com.tool.soat.entity.SoatRoles;
import com.tool.soat.entity.SoatUsers;
import com.tool.soat.service.PermissionService;
import org.apache.commons.lang3.StringUtils;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.util.CollectionUtils;

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
    PermissionService permissionService;

    @Override
    public boolean supports(AuthenticationToken token) {
        return token instanceof JWTToken;
    }

    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {

        String email = SoatJWTUtil.getEmail(principalCollection.getPrimaryPrincipal().toString());
        SoatUsers users = soatUsersMapper.queryUserByEmail(email);
        SimpleAuthorizationInfo authorizationInfo = new SimpleAuthorizationInfo();
        if (!StringUtils.isEmpty(email)) {
            SoatRoles roles = soatRolesMapper.queryRolesByUser(users.getId());
            if(roles!=null){
                authorizationInfo.addRole(roles.getRoleTag());
            }
            Set<String> strings = permissionService.queryCurrentPermission(email);
            if(!CollectionUtils.isEmpty(strings)){
                for (String per: strings) {
                    if (per == null || StringUtils.isEmpty(per)){
                        continue;
                    }
                    authorizationInfo.addStringPermission(per);
                }
                return authorizationInfo;
            }
        }
        return null;
    }

    /**
     * 验证当前登录的用户
     */
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken auth) throws AuthenticationException {
        String token = (String) auth.getCredentials();
        // 解密获得username，用于和数据库进行对比
        String email = SoatJWTUtil.getEmail(token);
        if (StringUtils.isEmpty(email)) {
            throw new AuthenticationException("token错误!");
        }

        SoatUsers soatUsers = soatUsersMapper.queryUserByEmail(email);
        if (soatUsers == null) {
            throw new AuthenticationException("用户不存在!");
        }

        if (soatUsers.equals(true)) {
            throw new AuthenticationException("账号已被禁用!");
        }

        try {
            if (SoatJWTUtil.verify(token, email)) {
                return new SimpleAuthenticationInfo(token, token, getName());
            } else {
                throw new AuthenticationException("token认证失败!");
            }
        } catch (TokenExpiredException e) {
            throw new AuthenticationException("token已过期!");
        } catch (SignatureVerificationException e) {
            throw new AuthenticationException("密码不正确!");
        }
    }

    /**
     * 清除登陆用户授权信息缓存.
     */
    public void clearCached() {
        this.clearCachedAuthorizationInfo(SecurityUtils.getSubject().getPrincipals());
    }

}
