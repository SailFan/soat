package com.tool.soat.entity;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.xml.crypto.Data;
import java.util.List;

@lombok.Data
@ToString
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Document(collection="soat_project")
public class SoatProject {

    @Id
    private Integer id;
    private String projectName;
    private String basePath;
    private String projectType;
    private Integer uId;
    private Data addTime;
    private Data upTime;
    private String global;
    private List<SoatEnv> env;
    private List<SoatTag> tag;
}
