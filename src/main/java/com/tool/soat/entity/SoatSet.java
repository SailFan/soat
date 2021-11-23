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
public class SoatSet implements Serializable {

    private Integer id;
    private String name;
    private Date createTime;
    private Date updateTime;
    private String creater;
    private String updater;
    private String baseUrl;
    private static final long serialVersionUID = 1L;

}