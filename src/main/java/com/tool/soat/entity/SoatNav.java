package com.tool.soat.entity;

import lombok.*;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

@Data
@ToString
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class SoatNav implements Serializable {

    private Integer id;

    private String navName;

    private Integer level;

    private String path;

    private static final long serialVersionUID = 1L;

    private List<SoatNav> list = new LinkedList<>();

}