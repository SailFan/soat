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
    SET_CREATE_FAIL_CODE(201, "集合创建失败");

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
