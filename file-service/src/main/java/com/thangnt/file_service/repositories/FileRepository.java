package com.thangnt.file_service.repositories;

import com.thangnt.file_service.dto.FileInfo;
import org.springframework.core.io.Resource;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;

public interface FileRepository {
    FileInfo store(MultipartFile file) throws IOException;
    Resource getFile(String fileName) throws IOException;
}
