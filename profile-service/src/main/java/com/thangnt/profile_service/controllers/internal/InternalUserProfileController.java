package com.thangnt.profile_service.controllers.internal;

import com.thangnt.profile_service.dto.ApiResponse;
import com.thangnt.profile_service.dto.requests.UserProfileRequest;
import com.thangnt.profile_service.dto.responses.UserProfileResponse;
import com.thangnt.profile_service.services.UserProfileService;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/internal/users")
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
@RequiredArgsConstructor
public class InternalUserProfileController
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

}
