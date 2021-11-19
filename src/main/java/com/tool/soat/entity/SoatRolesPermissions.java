package com.tool.soat.entity;

import lombok.*;

import java.io.Serializable;


@Data
@ToString
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class SoatRolesPermissions implements Serializable {

    private Integer rId;
    private Integer pId;

}