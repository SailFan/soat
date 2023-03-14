package com.tool.soat.entity;

import com.tool.soat.common.util.AutoIncKey;
import lombok.*;

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

    @AutoIncKey
    @Id
    private int id=0;
    private String projectName;
    private String basePath;
    private Boolean projectType;
    private String creater;
    private Boolean run;
    private String cron;
    private Date addTime;
    private Date upTime;
    private String global;
    private List<SoatEnv> env;
    private List<SoatTag> tag;
    private Date startTime;
    private Date endTime;

}
