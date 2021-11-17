package com.tool.soat.entity;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.io.Serializable;
import java.util.Set;


@Data
@Getter
@Setter
@ToString
public class SoatPermission implements Serializable {

    private Integer pid;
    private String code;
    private String name;
    private Set<SoatChildrePermission> queryChildrePermission;

}

