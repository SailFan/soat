package com.tool.soat.entity;

import lombok.*;

import java.io.Serializable;


@Data
@ToString
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class SoatUsers implements Serializable {

    private Integer id;
    private String username;
    private String password;
    private String salt;
    private String nickname;
    private String email;
    private String role;
    private String phone;
    private Boolean status;
    private static final long serialVersionUID = 1L;

}