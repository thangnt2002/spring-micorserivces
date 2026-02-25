package com.thangnt.file_service.controllers;

import com.thangnt.file_service.dto.ApiResponse;
import com.thangnt.file_service.dto.responses.FileDataResponse;
import com.thangnt.file_service.dto.responses.FileResponse;
import com.thangnt.file_service.service.FileService;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import lombok.extern.slf4j.Slf4j;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@RestController
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
@Slf4j
public class FileController {
    FileService fileService;

    @PostMapping("/media/upload")
    public ApiResponse<FileResponse> upload(@RequestParam MultipartFile file) throws IOException {
        log.info("logne");
        return fileService.upload(file);
    }

    @GetMapping("/media/download/{fileName}")
    public ResponseEntity<Resource> download(@PathVariable String fileName) throws IOException {
        FileDataResponse fileData = fileService.downLoad(fileName);

        return ResponseEntity.<Resource>ok()
                .header(HttpHeaders.CONTENT_TYPE, fileData.contentType())
                .body(fileData.resource());

    }
}
