package com.thangnt.profile_service.controllers;

import com.thangnt.profile_service.dto.ApiResponse;
import com.thangnt.profile_service.dto.requests.UserProfileRequest;
import com.thangnt.profile_service.dto.responses.UserProfileResponse;
import com.thangnt.profile_service.services.UserProfileService;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
@RequiredArgsConstructor
public class UserProfileController
{
    UserProfileService userProfileService;
    @GetMapping("/{id}")
    private ApiResponse<UserProfileResponse> findById(@PathVariable String id){
        return userProfileService.findById(id);
    }

    @PreAuthorize("hasRole('ADMIN')")
    @GetMapping
     ApiResponse<List<UserProfileResponse>> getAll(){
        return userProfileService.getAll();
    }
}
