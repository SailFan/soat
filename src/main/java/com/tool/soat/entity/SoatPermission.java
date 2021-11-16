package com.tool.soat.entity;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.io.Serializable;
import java.util.List;

@Data
@Getter
@Setter
@ToString
public class SoatPermission implements Serializable {

    private Integer pid;
    private String code;
    private String name;
    private Integer level;
    private List<SoatPermission> queryPermission;
    private static final long serialVersionUID = 1L;

}