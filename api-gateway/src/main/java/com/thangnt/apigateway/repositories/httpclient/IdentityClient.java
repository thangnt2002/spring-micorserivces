package com.thangnt.apigateway.repositories.httpclient;

import com.thangnt.apigateway.dto.ApiResponse;
import com.thangnt.apigateway.dto.request.IntrospectTokenRequest;
import com.thangnt.apigateway.dto.response.IntrospectTokenResponse;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.service.annotation.HttpExchange;
import org.springframework.web.service.annotation.PostExchange;
import reactor.core.publisher.Mono;

@HttpExchange
public interface IdentityClient {
    @PostExchange("/auth/introspect")
    Mono<ApiResponse<IntrospectTokenResponse>> introspectToken(
            @RequestBody IntrospectTokenRequest request
    );
}
