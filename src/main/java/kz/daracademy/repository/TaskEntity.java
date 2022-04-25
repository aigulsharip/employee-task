package kz.daracademy.repository;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;
import org.springframework.data.elasticsearch.annotations.Field;
import org.springframework.data.elasticsearch.annotations.FieldType;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Document(indexName = "employee-task")
public class TaskEntity {

    @Id
    @Field(type = FieldType.Keyword)
    private String taskId;

    @Field(type = FieldType.Keyword)
    private String initiatorId;


    @Field(type = FieldType.Keyword)
    private String executorId;


    @Field(type = FieldType.Text)
    private String type;


    @Field(type = FieldType.Text)
    private String description;



}
