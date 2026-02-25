package com.thangnt.file_service.service;

import com.thangnt.file_service.dto.ApiResponse;
import com.thangnt.file_service.dto.responses.FileDataResponse;
import com.thangnt.file_service.dto.responses.FileResponse;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

public interface FileService {
    ApiResponse<FileResponse> upload(MultipartFile file) throws IOException;
    FileDataResponse downLoad(String fileName) throws IOException;
}
