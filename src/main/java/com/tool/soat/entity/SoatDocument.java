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
@Document(collection="soat_document")
public class SoatDocument {

    @AutoIncKey
    @Id
    private int id=0;
    private String documentName;
    private String creater;
    private Boolean isShow;
    private Date updateTime;
}
