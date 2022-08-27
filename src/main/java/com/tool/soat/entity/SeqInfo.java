package com.tool.soat.entity;

import lombok.*;
import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import retrofit2.http.GET;

/**
 * @Description:
 * @Author: Sail
 * @CreateTime: 2022/8/23 22:49
 * @File: SeqInfo
 * @Software: IntelliJIDEA
 */
@Data
@ToString
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Document(collection = "sequence")
public class SeqInfo {
    @Id
    private ObjectId id;//主键
    private Integer seqId;//序列值
    private String collName;//集合名称


}
