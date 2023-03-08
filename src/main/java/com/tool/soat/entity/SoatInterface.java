package com.tool.soat.entity;

import com.tool.soat.common.util.AutoIncKey;
import lombok.*;

import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.HashMap;
import java.util.List;




@Data
@ToString
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Document(collection="soat_interface")

public class SoatInterface{
    @AutoIncKey
    @Id
    private int id=0;
    private String name;
    private Boolean status;
    private String path;
    private String domain;
    private String procotol;
    private String method;
    private List<SoatParams> params;
    private Boolean run;
    private List<SoatHeaders> headers;
    private Integer setId;
    private String postType;
    private String bodyType;
    private String body;
    private String author;
    private String editer;
    private Integer projectId;



}