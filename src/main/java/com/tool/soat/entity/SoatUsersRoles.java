package com.tool.soat.entity;

import lombok.*;

import java.io.Serializable;


@Data
@ToString
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class SoatUsersRoles implements Serializable {

    private Integer uId;
    private Integer rId;

}