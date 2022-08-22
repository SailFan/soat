package com.tool.soat.entity;

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

    @Id
    private ObjectId interfaceId;
    private String name;
    private Boolean status;
    private String path;
    private String procotol;
    private String method;
    private String params;
    private String run;
    private List<HashMap<String,Object>> headers;
    private Integer setId;
    private String request_type;
    private String author;
    private String editer;
    private Integer projectId;


}