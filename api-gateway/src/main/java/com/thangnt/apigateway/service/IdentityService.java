package com.thangnt.apigateway.service;

import com.thangnt.apigateway.dto.ApiResponse;
import com.thangnt.apigateway.dto.request.IntrospectTokenRequest;
import com.thangnt.apigateway.dto.response.IntrospectTokenResponse;
import reactor.core.publisher.Mono;

public interface IdentityService {
    Mono<ApiResponse<IntrospectTokenResponse>> introspectToken(String token);
}
