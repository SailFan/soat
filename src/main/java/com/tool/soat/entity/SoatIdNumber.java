package com.tool.soat.entity;

import lombok.*;

import java.io.Serializable;


@Data
@ToString
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class SoatIdNumber implements Serializable {

    private Integer id;

    private String idNumber;

    private String remark;

    private String isUse;

    private String isHide;

}