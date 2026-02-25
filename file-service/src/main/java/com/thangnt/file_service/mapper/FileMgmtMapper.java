package com.thangnt.file_service.mapper;

import com.thangnt.file_service.dto.FileInfo;
import com.thangnt.file_service.entities.FileMgmt;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface FileMgmtMapper {
    @Mapping(target = "id", source = "name")
    FileMgmt toFileMgmt(FileInfo fileInfo);
}
