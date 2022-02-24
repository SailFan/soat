package com.tool.soat.entity;

import lombok.*;
import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;


import java.util.Date;
import java.util.List;

@Data
@ToString
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Document(collection="soat_project")
public class SoatProject {

    @Id
    private ObjectId id;
    private String projectName;
    private String basePath;
    private Boolean projectType;
    private Integer uId;
    private Date addTime;
    private Date upTime;
    private String global;
    private List<SoatEnv> env;
    private List<SoatTag> tag;

}
