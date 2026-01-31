package com.thangnt.profile_service.services;

import com.thangnt.profile_service.dto.ApiResponse;
import com.thangnt.profile_service.dto.requests.UserProfileRequest;
import com.thangnt.profile_service.dto.responses.UserProfileResponse;

import java.util.List;

public interface UserProfileService {
    ApiResponse<UserProfileResponse> create(UserProfileRequest request);
    ApiResponse<UserProfileResponse> update(UserProfileRequest request);
    ApiResponse<UserProfileResponse> findById(String id);
    ApiResponse<List<UserProfileResponse>> getAll();
}
