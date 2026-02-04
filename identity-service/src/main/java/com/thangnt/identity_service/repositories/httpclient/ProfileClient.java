package com.thangnt.identity_service.repositories.httpclient;

import com.thangnt.identity_service.configuration.ClientAuthenRequestInterceptor;
import com.thangnt.identity_service.dto.request.UserProfileCreationRequest;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@FeignClient(name = "profile-service",
        url = "${app.service.profile}",
        configuration = {ClientAuthenRequestInterceptor.class}
)
public interface ProfileClient {

    @PostMapping(value = "/internal/users/registration", produces = MediaType.APPLICATION_JSON_VALUE)
    Object createUserProfile(@RequestBody UserProfileCreationRequest request);

}