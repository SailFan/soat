package com.tool.soat.config;

import at.pollux.thymeleaf.shiro.dialect.ShiroDialect;
import com.tool.soat.shiro.SoatRealm;
import org.apache.shiro.authc.credential.HashedCredentialsMatcher;
import org.apache.shiro.cache.ehcache.EhCacheManager;
import org.apache.shiro.spring.security.interceptor.AuthorizationAttributeSourceAdvisor;
import org.apache.shiro.spring.web.ShiroFilterFactoryBean;
import org.apache.shiro.web.mgt.CookieRememberMeManager;
import org.apache.shiro.web.mgt.DefaultWebSecurityManager;
import org.apache.shiro.web.servlet.SimpleCookie;
import org.apache.shiro.web.session.mgt.DefaultWebSessionManager;
import org.springframework.aop.framework.autoproxy.DefaultAdvisorAutoProxyCreator;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.HashMap;

/**
 * @Description:
 * @Author: Sail
 * @CreateTime: 2021/6/24 6:01 下午
 * @File: ShiroConfig
 * @Software: IntelliJIDEA
 */

@Configuration
public class ShiroConfig {


    @Bean
    public HashedCredentialsMatcher getHashedCredentialsMatcher(){
        HashedCredentialsMatcher matcher = new HashedCredentialsMatcher();
        matcher.setHashAlgorithmName("md5");
        matcher.setHashIterations(1);

        return matcher;
    }

    @Bean
    public EhCacheManager getEhCacheManager(){
        EhCacheManager ehCacheManager = new EhCacheManager();
        ehCacheManager.setCacheManagerConfigFile("classpath:ehcache.xml");
        return ehCacheManager;
    }




    @Bean
    public AuthorizationAttributeSourceAdvisor getAuthorizationAttributeSourceAdvisor(DefaultWebSecurityManager defaultWebSecurityManager){
        AuthorizationAttributeSourceAdvisor authorizationAttributeSourceAdvisor = new AuthorizationAttributeSourceAdvisor();
        authorizationAttributeSourceAdvisor.setSecurityManager(defaultWebSecurityManager);
        return authorizationAttributeSourceAdvisor;
    }

    @Bean
    public DefaultAdvisorAutoProxyCreator getDefaultAdvisorAutoProxyCreator(){
        DefaultAdvisorAutoProxyCreator defaultAdvisorAutoProxyCreator = new DefaultAdvisorAutoProxyCreator();
        defaultAdvisorAutoProxyCreator.setProxyTargetClass(true);
        return defaultAdvisorAutoProxyCreator;
    }

    @Bean
    public ShiroDialect getShiroDialect(){
        return new  ShiroDialect();
    }

    @Bean
    public SoatRealm getSoatRealm(HashedCredentialsMatcher matcher){
        SoatRealm soatRealm = new SoatRealm();
        soatRealm.setCredentialsMatcher(matcher);
        return soatRealm;
    }

    @Bean
    public DefaultWebSessionManager getDefaultWebSessionManager(){
        DefaultWebSessionManager defaultWebSessionManager = new DefaultWebSessionManager();
        defaultWebSessionManager.setGlobalSessionTimeout(86400000);
        return defaultWebSessionManager;
    }

    @Bean
    public CookieRememberMeManager getCookieRememberMeManager(){
        CookieRememberMeManager cookieRememberMeManager = new CookieRememberMeManager();
        SimpleCookie cookie = new SimpleCookie("rememberMe");
        cookie.setMaxAge(30*24*60*60);
        cookieRememberMeManager.setCookie(cookie);
        return cookieRememberMeManager;
    }



    @Bean
    public DefaultWebSecurityManager getDefaultWebSecurityManager(SoatRealm soatRealm,EhCacheManager ehCacheManager){
        DefaultWebSecurityManager defaultWebSecurityManager = new DefaultWebSecurityManager();
        defaultWebSecurityManager.setRealm(soatRealm);
        defaultWebSecurityManager.setCacheManager(ehCacheManager);
        defaultWebSecurityManager.setSessionManager(getDefaultWebSessionManager());
        defaultWebSecurityManager.setRememberMeManager(getCookieRememberMeManager());
        return defaultWebSecurityManager;
    }


    @Bean
    public ShiroFilterFactoryBean shiroFilterFactoryBean(DefaultWebSecurityManager defaultWebSecurityManager){
        ShiroFilterFactoryBean filter = new ShiroFilterFactoryBean();
        filter.setSecurityManager(defaultWebSecurityManager);
        HashMap<String, String> map = new HashMap<>();
        map.put("/", "anon");
        map.put("/logout","logout");
        filter.setFilterChainDefinitionMap(map);
//        filter.setLoginUrl("/");
//        filter.setUnauthorizedUrl("/");

        return filter;
    }
}
