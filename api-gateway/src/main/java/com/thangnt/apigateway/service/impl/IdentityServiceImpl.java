package com.thangnt.apigateway.service.impl;

import com.thangnt.apigateway.dto.ApiResponse;
import com.thangnt.apigateway.dto.request.IntrospectTokenRequest;
import com.thangnt.apigateway.dto.response.IntrospectTokenResponse;
import com.thangnt.apigateway.repositories.httpclient.IdentityClient;
import com.thangnt.apigateway.service.IdentityService;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

@Service
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
@Slf4j
public class IdentityServiceImpl implements IdentityService {

    IdentityClient identityClient;

    public Mono<ApiResponse<IntrospectTokenResponse>> introspectToken(String token){
        return identityClient.introspectToken(IntrospectTokenRequest.builder()
                .token(token)
                .build());
    }
}
