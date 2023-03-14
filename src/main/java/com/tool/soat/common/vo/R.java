package com.tool.soat.common.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

/**
 * @Description:
 * @Author: 凡子
 * @CreateTime: 2021/8/2 10:43 下午
 * @File: R
 * @Software: IntelliJIDEA
 */
@Data

@NoArgsConstructor
@ToString
public class R {
    private Integer code;
    private Object data="";
    private String msg;

    public R(Integer code, Object data, String msg) {
        if (data==null){
            data="";
        }
        this.code = code;
        this.data = data;
        this.msg = msg;
    }

    public static R ok (Object data){
        return new R(200,data,"");
    }
    public static R ok (Integer code,Object data,String msg){
        return new R(200,data,msg);
    }
    public static R error(RHttpStatusEnum rHttpStatusEnum){
        return new R(rHttpStatusEnum.getCode(),"", rHttpStatusEnum.getMessage());
    }
}