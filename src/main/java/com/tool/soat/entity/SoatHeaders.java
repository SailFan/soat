package com.tool.soat.entity;


import lombok.*;
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
    @Id
    private Integer id;
    private String name;
    private String value;
}
