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
public class SoatRoles implements Serializable {

    private Integer rid;

    private String roleName;

    private List<SoatPermission> permissionsList;

    private static final long serialVersionUID = 1L;



}