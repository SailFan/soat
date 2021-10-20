package com.tool.soat.common.vo;

/**
 * @Description:
 * @Author: Sail
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
    NAV_QUERY_FAIL(40004,"获取导航栏失败");


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
