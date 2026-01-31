package com.thangnt.profile_service.services.impl;

import com.thangnt.profile_service.dto.ApiResponse;
import com.thangnt.profile_service.dto.requests.UserProfileRequest;
import com.thangnt.profile_service.dto.responses.UserProfileResponse;
import com.thangnt.profile_service.entities.UserProfile;
import com.thangnt.profile_service.mapper.UserProfileMapper;
import com.thangnt.profile_service.repositories.UserProfileRepository;
import com.thangnt.profile_service.services.UserProfileService;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
@RequiredArgsConstructor
public class UserProfileServiceImpl implements UserProfileService {

    UserProfileRepository userProfileRepository;
    UserProfileMapper userProfileMapper;

    @Override
    public ApiResponse<UserProfileResponse> create(UserProfileRequest request) {
        UserProfile userProfile = userProfileMapper.toUserProfile(request);
        userProfile = userProfileRepository.save(userProfile);
        return ApiResponse.<UserProfileResponse>builder()
                .success(true)
                .code(201)
                .data(userProfileMapper.toUserProfileResponse(userProfile))
                .build();
    }

    @Override
    public ApiResponse<UserProfileResponse> update(UserProfileRequest request) {
        return null;
    }

    @Override
    public ApiResponse<UserProfileResponse> findById(String id) {
        UserProfile userProfile = userProfileRepository.findById(id).get();
        return ApiResponse.<UserProfileResponse>builder()
                .success(true)
                .code(200)
                .data(userProfileMapper.toUserProfileResponse(userProfile))
                .build();
    }

    @Override
    public ApiResponse<List<UserProfileResponse>> getAll() {
        List<UserProfileResponse> response = userProfileRepository
                .findAll()
                .stream()
                .map(userProfileMapper::toUserProfileResponse)
                .toList();
        return ApiResponse.<List<UserProfileResponse>>builder()
                .success(true)
                .code(200)
                .data(response)
                .build();
    }
}
