package com.tool.soat.controller;

import com.tool.soat.common.util.JwtUtil;
import com.tool.soat.common.vo.R;
import com.tool.soat.common.vo.RHttpStatusEnum;
import com.tool.soat.service.AuthService;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.LockedAccountException;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.crypto.hash.Md5Hash;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletResponse;
import java.util.HashMap;
import java.util.Map;




@RestController
@RequestMapping("/auth")
public class AuthController {
    Logger logger = LoggerFactory.getLogger(getClass());

    @Resource
    AuthService authService;

    @RequestMapping(value = "/")
    public String index(){
        return "success";
    }


    @RequestMapping(value = "/login", method = RequestMethod.POST,consumes="application/json")
    public R login(@RequestBody Map<String,Object> map, ServletResponse response){
        String username= (String) map.get("username");
        String password= (String) map.get("password");
        try {
            HashMap<String, String> hashMap = new HashMap<>();
            hashMap.put("username","liuwenfan");
            authService.checkLogin(username,password);
            String jwtToken = JwtUtil.createToken(hashMap);
            HashMap<Object, Object> hashToken = new HashMap<>();
            hashToken.put("token",jwtToken);
//            ((HttpServletResponse) response).setHeader(JwtUtil.AUTH_HEADER, jwtToken);
            return new R(RHttpStatusEnum.SUCCESS.getCode(), hashToken,RHttpStatusEnum.LOGIN_SUCCESS.getMessage());
        } catch (UnknownAccountException uae) {
            return new R(RHttpStatusEnum.LOGIN_FAIL_MATCH.getCode(), "",RHttpStatusEnum.LOGIN_FAIL_MATCH.getMessage());
        } catch (IncorrectCredentialsException ice) {
            return new R(RHttpStatusEnum.LOGIN_FAIL_Incorrect.getCode(), "",RHttpStatusEnum.LOGIN_FAIL_Incorrect.getMessage());
        } catch (LockedAccountException lae) {
            return new R(RHttpStatusEnum.LOGIN_FAIL.getCode(), "",RHttpStatusEnum.LOGIN_FAIL.getMessage());
        } catch (AuthenticationException au) {
            return new R(RHttpStatusEnum.LOGIN_FAIL.getCode(), "",RHttpStatusEnum.LOGIN_FAIL.getMessage());
        } catch (Exception e) {
            return new R(RHttpStatusEnum.LOGIN_FAIL.getCode(), "",RHttpStatusEnum.LOGIN_FAIL.getMessage());
        }
    }

    @RequestMapping("/regist")
    public String regist(String username, String password){
        Md5Hash md5Hash = new Md5Hash(password,"soat");
        System.out.println(md5Hash);
        return "111";
    }

}
