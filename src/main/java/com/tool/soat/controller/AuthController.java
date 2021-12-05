package com.tool.soat.controller;

import com.tool.soat.common.util.JwtUtil;
import com.tool.soat.common.vo.R;
import com.tool.soat.common.vo.RHttpStatusEnum;
import com.tool.soat.entity.SoatUsers;
import com.tool.soat.service.AuthService;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.LockedAccountException;
import org.apache.shiro.authc.UnknownAccountException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.util.DigestUtils;
import org.springframework.web.bind.annotation.*;
import javax.annotation.Resource;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.List;
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
            return new R(RHttpStatusEnum.LOGIN_SUCCESS.getCode(), hashToken,RHttpStatusEnum.LOGIN_SUCCESS.getMessage());
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

    @GetMapping("/logout")
    public R logout() {
        return new R(RHttpStatusEnum.SUCCESS.getCode(),"",RHttpStatusEnum.SUCCESS.getMessage());
    }

    @RequestMapping(value = "/modificationUser", method = RequestMethod.POST,consumes="application/json")
    public R modificationUser(@RequestBody SoatUsers soatUsers){
        try{
            Integer code = authService.modificationUserS(soatUsers);
            if (code!=1){
                return new R(RHttpStatusEnum.MODIFICATION_USER_FAIL.getCode(), "",RHttpStatusEnum.MODIFICATION_USER_FAIL.getMessage());
            }
            return new R(RHttpStatusEnum.SUCCESS.getCode(), "",RHttpStatusEnum.SUCCESS.getMessage());
        }catch (Exception e){
            return new R(RHttpStatusEnum.MODIFICATION_USER_FAIL.getCode(), "",RHttpStatusEnum.MODIFICATION_USER_FAIL.getMessage());
        }
    }


    @GetMapping("/getUser")
    public R getUserList(HttpServletRequest httpServletRequest){

        String username = httpServletRequest.getParameter("query");
        Integer pagesize = Integer.parseInt(httpServletRequest.getParameter("pagesize"));
        Integer pagenum = Integer.parseInt(httpServletRequest.getParameter("pagenum"));
        if (username==""){
            username=null;
        }
        try {
            List<SoatUsers> users = authService.queryBySizeAndNumS(pagesize, pagenum,username);
            HashMap<String, Object> map = new HashMap<>();
            map.put("total", users.size());
            map.put("users", users);
            return new R(RHttpStatusEnum.SUCCESS.getCode(), map,RHttpStatusEnum.SUCCESS.getMessage());

        }catch (Exception e){
            return new R(RHttpStatusEnum.QUERY_FAIL.getCode(), "",RHttpStatusEnum.QUERY_FAIL.getMessage());
        }
    }

    @RequestMapping(value = "/addUser", method = RequestMethod.POST,consumes="application/json")
    public R addUser(@RequestBody SoatUsers soatUsers) {
        SoatUsers users = authService.queryEmailOrPhone(soatUsers.getEmail(), soatUsers.getPhone());
        if (users!=null) return new R(RHttpStatusEnum.ADD_USER_REPETITION.getCode(), "",RHttpStatusEnum.ADD_USER_REPETITION.getMessage());
        try {

            String password=soatUsers.getPassword();
            String soat="soat";
            String hex = soat + password;
            soatUsers.setPassword(DigestUtils.md5DigestAsHex(hex.getBytes()));
            authService.insertUser(soatUsers);
            return new R(RHttpStatusEnum.SUCCESS.getCode(), "",RHttpStatusEnum.SUCCESS.getMessage());
        }catch (Exception e){
            return new R(RHttpStatusEnum.ADD_FAIL.getCode(), "",RHttpStatusEnum.ADD_FAIL.getMessage());
        }
    }

    @RequestMapping(value = "/getUserDetail", method = RequestMethod.GET)
    public R getUserDetail(Integer id){
        try {
            SoatUsers users = authService.queryUserS(id);
            return new R(RHttpStatusEnum.SUCCESS.getCode(), users,RHttpStatusEnum.SUCCESS.getMessage());
        }catch (Exception e){
            return new R(RHttpStatusEnum.QUERY_USER_FAIL.getCode(), "",RHttpStatusEnum.QUERY_USER_FAIL.getMessage());
        }

    }

    @GetMapping(value = "/changeStatus")
    public R changeStatus(Integer id){
        try {
            authService.changeStatus(id);
            return new R(RHttpStatusEnum.SUCCESS.getCode(), "",RHttpStatusEnum.SUCCESS.getMessage());
        }catch (Exception e){
            return new R(RHttpStatusEnum.CHANGE_STATUS_FAIL.getCode(), "",RHttpStatusEnum.CHANGE_STATUS_FAIL.getMessage());
        }
    }
    @GetMapping(value = "/queryUser")
    public R queryUser(Integer id){
        try {
            authService.changeStatus(id);
            return new R(RHttpStatusEnum.SUCCESS.getCode(), "",RHttpStatusEnum.SUCCESS.getMessage());
        }catch (Exception e){
            return new R(RHttpStatusEnum.CHANGE_STATUS_FAIL.getCode(), "",RHttpStatusEnum.CHANGE_STATUS_FAIL.getMessage());
        }
    }

    @GetMapping("/queryUserIsExist")
    public R queryUserIsExist(String username, String email, String phone){
        try {
            SoatUsers users = authService.queryEmailOrPhoneOrNameS(username, email, phone);
            if (users!=null) return new R(RHttpStatusEnum.USER_EXIST.getCode(), "",RHttpStatusEnum.USER_EXIST.getMessage());
            return new R(RHttpStatusEnum.USER_NOT_EXIST.getCode(), "",RHttpStatusEnum.USER_NOT_EXIST.getMessage());
        }catch (Exception e){
            return new R(RHttpStatusEnum.UNKNOWN_REASON.getCode(), "",RHttpStatusEnum.UNKNOWN_REASON.getMessage());
        }
    }

    @GetMapping("/delUser")
    public R delUser(Integer id){
        try {
            Integer primaryKey = authService.deleteByPrimaryKey(id);
            if (primaryKey!=1){
                return new R(RHttpStatusEnum.DELETE_USER_FAIL.getCode(), "",RHttpStatusEnum.DELETE_USER_FAIL.getMessage());
            }
            return new R(RHttpStatusEnum.SUCCESS.getCode(), "",RHttpStatusEnum.SUCCESS.getMessage());
        }catch (Exception e){
            return new R(RHttpStatusEnum.DELETE_USER_FAIL.getCode(), "",RHttpStatusEnum.DELETE_USER_FAIL.getMessage());
        }
    }


}
