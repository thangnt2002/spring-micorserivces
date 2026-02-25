package com.thangnt.file_service.entities;

import lombok.*;
import lombok.experimental.FieldDefaults;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.MongoId;

@Document(collection = "file_mgmt")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@FieldDefaults(level = AccessLevel.PRIVATE)
public class FileMgmt {

    @MongoId
    String id;
    String ownerId;
    String contentType;
    String md5CheckSum;
    String path;
}
