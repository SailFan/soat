package com.tool.soat.entity;


import com.tool.soat.common.util.AutoIncKey;
import lombok.*;
import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@ToString
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Document
public class SoatHeaders {

    private String key;
    private Object value;
}
