package com.thangnt.identity_service.mapper;

import com.thangnt.identity_service.dto.request.UserCreationRequest;
import com.thangnt.identity_service.dto.request.UserProfileCreationRequest;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface UserProfileMapper {
    UserProfileCreationRequest toUserProfileRequest(UserCreationRequest request);

}
