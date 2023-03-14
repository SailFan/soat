package com.tool.soat.common.vo;

/**
 * @Description:
 * @Author: 凡子
 * @CreateTime: 2021/8/2 11:57 下午
 * @File: RConstants
 * @Software: IntelliJIDEA
 */
public enum RHttpStatusEnum {


    SUCCESS(20000,"操作成功"),
    SET_QUERY_FAIL(20001,"测试集查询错误"),
    UNKNOWN_REASON(20002, "未知错误"),
    SET_CREATE_FAIL_CODE(201, "集合创建失败"),
    LOGIN_SUCCESS(20003,"登录成功"),
    LOGIN_FAIL_MATCH(40001,"用户名与密码不匹配，请检查后重新输入"),
    LOGIN_FAIL_Incorrect(40002,"用户名与密码不匹配，请检查后重新输入"),
    LOGIN_FAIL(40003,"登录失败,请联系网站管理员"),
    QUERY_FAIL(40005,"获取用户列表失败"),
    ADD_FAIL(40007,"新增用户失败"),
    MODIFICATION_USER_FAIL(40012,"修改用户失败"),
    USER_EXIST(40009,"用户已经存在"),
    USER_NOT_EXIST(40011,"用户不存在"),
    QUERY_USER_FAIL(40010,"查询用户失败"),
    CHANGE_STATUS_FAIL(40008,"修改用户状态失败"),
    ADD_USER_REPETITION(40006,"邮箱或者电话不可重复"),
    DELETE_USER_FAIL(40013,"删除用户失败"),
    QUERY_ROLE_LIST_FAIL(40014,"获取角色列表"),
    ADD_ROLE_FAIL(40015,"增加角色失败"),
    EDIT_ROLE_FAIL(40016,"修改角色失败"),
    QUERY_ROLE_FAIL(40024,"获取指定角色失败"),
    QUERY_PERMISSIONS_FAIL(40018,"查询权限失败"),
    REMOVE_PR_FAIL(40019,"删除角色权限关联关系失败"),
    ADD_PR_FAIL(40020,"新建角色权限关联关系"),
    ADD_UR_FAIL(40021,"新建用户角色关联失败"),
    REMOVE_UR_FAIL(40022,"移除用户角色关联失败"),
    DEL_ROLE_FAIL(40023,"删除角色失败"),
    ADD_PERMISSION_ROLE_FAIL(40025,"新增角色用户关联关系失败"),
    GET_CURRENT_ROLE_FAIL(40026,"获取当前角色"),
    QUERY_ASSIGN_ROLE_PERMISSION_FAIL(40024,"获取指定角色权限失败"),
    NAV_QUERY_FAIL(40004,"获取导航栏失败"),
    CREATE_PROJECT_ERROR(40028,"创建工程失败"),
    QUERY_PROJECT_ERROR(40029,"获取测试集列表失败"),
    INTERFACE_ADD_FAIL(40027,"获取接口参数失败"),
    USER_LOCK(40030,"用户已经被锁定"),
    PERMISSION_DENIED_CODE(40031, "无此权限"),
    INVALID_LOGIN_CODE(40032,"登录失败"),
    ADD_INTERFACE_FAIL_CODE(40034,"新增接口失败"),
    RUN_INTERFACE_FAIL_CODE(40035,"运行接口失败"),
    RUN_ADD_TWO_CODE(40036,"新增接口名称不可重复"),
    INTERFACE_LIST_FAIL(40037,"获取接口列表失败"),
    INTERFACE_DEL_FAIL(40038,"删除接口失败"),
    GET_ONE_INTERFACE_FAIL(40039,"获取当前接口失败"),
    GENGEATE_HEADERS_INTERFACE_FAIL(40040,"获取默认请求头失败"),
    UPDATE_ONE_INTERFACE_FAIL(40041,"更新当前接口失败"),
    GET_DEFAULT_HEADER_FAIL(40042,"获取接口默认的请求头失败"),
    RUN_ONE_INTERFACE_FAIL(40043,"运行接口失败"),
    DOCUMENT_OPERATION(40045,"文档操作失败"),
    RUN_DETAIL_INTERFACE_FAIL(40044,"运行接口失败"),
    SERVER_ERROR(40033,"服务器错误");
    Integer code;
    String msg;

    RHttpStatusEnum(Integer code, String msg){
        this.code=code;
        this.msg=msg;
    }

    public Integer getCode() {
        return code;
    }

    public String getMessage() {
        return msg;
    }

}
