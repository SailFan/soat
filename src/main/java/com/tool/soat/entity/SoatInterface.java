package com.tool.soat.entity;

import lombok.*;

import java.io.Serializable;


@Data
@ToString
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class SoatInterface implements Serializable {

    private Integer id;
    private String name;
    private String path;
    private String method;
    private String params;
    private Integer run;
    private String headers;
    private Integer setId;
    private static final long serialVersionUID = 1L;

}