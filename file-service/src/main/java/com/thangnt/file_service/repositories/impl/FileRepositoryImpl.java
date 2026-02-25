package com.thangnt.file_service.repositories.impl;

import com.thangnt.file_service.dto.FileInfo;
import com.thangnt.file_service.repositories.FileRepository;
import lombok.experimental.NonFinal;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.ByteArrayResource;
import org.springframework.core.io.Resource;
import org.springframework.stereotype.Repository;
import org.springframework.util.DigestUtils;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.nio.file.*;
import java.util.Objects;
import java.util.UUID;

@Repository
public class FileRepositoryImpl implements FileRepository {

    @NonFinal
    @Value("${app.file.storage-dir}")
    String storageDir;

    @NonFinal
    @Value("${app.file.download-prefix}")
    String downloadPrefix;

    @Override
    public FileInfo store(MultipartFile file) throws IOException {
        Path folder = Paths.get(storageDir);
        String fileExtension = StringUtils.getFilenameExtension(file.getOriginalFilename());
        String fileName =
                Objects.isNull(fileExtension) ? UUID.randomUUID().toString()
                : UUID.randomUUID() + "." + fileExtension;

        Path filePath = folder.resolve(fileName).normalize();
        Files.copy(file.getInputStream(), filePath, StandardCopyOption.REPLACE_EXISTING);

        return FileInfo.builder()
                .name(fileName)
                .size(file.getSize())
                .contentType(file.getContentType())
                .md5CheckSum(DigestUtils.md5DigestAsHex(file.getInputStream()))
                .path(filePath.toString())
                .url(downloadPrefix + fileName)
                .build();
    }

    @Override
    public Resource getFile(String filePath) throws IOException {
        byte[] resource = Files.readAllBytes(Path.of(filePath));
        return new ByteArrayResource(resource);
    }
}
