package com.tool.soat.entity;


import lombok.*;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@ToString
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Document
public class SoatParams {


    private String key;
    private Object value;
}
