package com.tool.soat.entity;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;


@Data
@ToString
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Document
public class SoatEnv {
   @Id
   private Integer id;
   private List<SoatHeaders> headers;
   private String name;
   private String domains;
}
