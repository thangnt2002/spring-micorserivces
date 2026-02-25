package com.thangnt.file_service.repositories;

import com.thangnt.file_service.entities.FileMgmt;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface FileMgmtRepositories extends MongoRepository<FileMgmt, String> {
}
