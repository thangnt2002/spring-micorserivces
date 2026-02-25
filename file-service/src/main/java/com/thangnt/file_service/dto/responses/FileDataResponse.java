package com.thangnt.file_service.dto.responses;

import org.springframework.core.io.Resource;

public record FileDataResponse(String contentType, Resource resource) {}

