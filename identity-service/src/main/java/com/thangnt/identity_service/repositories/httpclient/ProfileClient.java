package com.thangnt.identity_service.repositories.httpclient;

import com.thangnt.identity_service.dto.request.UserProfileCreationRequest;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.Objects;

@FeignClient(name = "profile-service", url = "${app.service.profile")
public interface ProfileClient {

    @PostMapping(value = "/users", produces = MediaType.APPLICATION_JSON_VALUE)
    Object createUserProfile(@RequestBody UserProfileCreationRequest request);

}