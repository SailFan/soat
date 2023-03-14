package com.tool.soat.entity;

import com.tool.soat.common.util.AutoIncKey;
import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Date;


@Data
@ToString
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Document(collection="soat_document")
public class SoatDocument {

    @AutoIncKey
    @Id
    private int id=0;
    private String documentName;
    private String documentAbstract;
    private String creater;
    private Boolean isShow;
    private String value;
    private Date updateTime;

}
