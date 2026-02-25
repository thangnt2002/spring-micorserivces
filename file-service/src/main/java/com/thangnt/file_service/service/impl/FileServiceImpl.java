package com.thangnt.file_service.service.impl;

import com.thangnt.file_service.dto.ApiResponse;
import com.thangnt.file_service.dto.FileInfo;
import com.thangnt.file_service.dto.responses.FileDataResponse;
import com.thangnt.file_service.dto.responses.FileResponse;
import com.thangnt.file_service.entities.FileMgmt;
import com.thangnt.file_service.exception.ErrorCode;
import com.thangnt.file_service.exception.NotFoundException;
import com.thangnt.file_service.mapper.FileMgmtMapper;
import com.thangnt.file_service.repositories.FileMgmtRepositories;
import com.thangnt.file_service.repositories.FileRepository;
import com.thangnt.file_service.service.FileService;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@Service
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class FileServiceImpl implements FileService {

    FileMgmtRepositories fileMgmtRepositories;
    FileRepository fileRepository;
    FileMgmtMapper fileMapper;

    @Override
    public ApiResponse<FileResponse> upload(MultipartFile file) throws IOException {
        // store to folder
        FileInfo fileInfo = fileRepository.store(file);

        FileMgmt fileMgmt = fileMapper.toFileMgmt(fileInfo);
        String userId = SecurityContextHolder.getContext().getAuthentication().getName();
        fileMgmt.setOwnerId(userId);
        fileMgmtRepositories.save(fileMgmt);
        if(fileMgmt.getContentType() != null){

        }
        return ApiResponse.<FileResponse>builder()
                .code(200)
                .success(true)
                .data(FileResponse.builder()
                        .originalFileName(file.getOriginalFilename())
                        .url(fileInfo.getUrl())
                        .build())
                .build();
    }

    @Override
    public FileDataResponse downLoad(String fileName) throws IOException {
        var fileMgmt = fileMgmtRepositories.findById(fileName).orElseThrow(
                () -> new NotFoundException(ErrorCode.FILE_NOT_FOUND.getCode()));

        var resource = fileRepository.getFile(fileMgmt.getPath());

        return new FileDataResponse(fileMgmt.getContentType(), resource);
    }
}
