package com.tool.soat.entity;

import lombok.*;

import java.io.Serializable;


@Data
@ToString
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor

public class soatCPRelationKey implements Serializable {
    private Integer pcId;
    private Integer pId;

}