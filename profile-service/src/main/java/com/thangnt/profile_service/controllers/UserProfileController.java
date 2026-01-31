package com.thangnt.profile_service.controllers;

import com.thangnt.profile_service.dto.ApiResponse;
import com.thangnt.profile_service.dto.requests.UserProfileRequest;
import com.thangnt.profile_service.dto.responses.UserProfileResponse;
import com.thangnt.profile_service.services.UserProfileService;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/users")
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
@RequiredArgsConstructor
public class UserProfileController
{
    UserProfileService userProfileService;

    @PostMapping
    private ApiResponse<UserProfileResponse> create(@RequestBody UserProfileRequest request){
        return userProfileService.create(request);
    }

    @PutMapping
    private ApiResponse<UserProfileResponse> update(@RequestBody UserProfileRequest request){
        return userProfileService.update(request);
    }

    @GetMapping("/{id}")
    private ApiResponse<UserProfileResponse> findById(@PathVariable String id){
        return userProfileService.findById(id);
    }
}
