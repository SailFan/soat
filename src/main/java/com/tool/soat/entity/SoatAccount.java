package com.tool.soat.entity;

import lombok.*;

import java.io.Serializable;
import java.util.Date;

@Data
@ToString
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class SoatAccount implements Serializable {

    private Integer id;


    private String address;


    private String account;


    private String password;


    private String remark;


    private String cerater;


    private String type;

    private String updater;


    private Date updateTime;

}