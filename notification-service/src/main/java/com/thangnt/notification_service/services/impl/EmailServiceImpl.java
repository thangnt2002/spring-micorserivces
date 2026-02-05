package com.thangnt.notification_service.services.impl;

import com.thangnt.notification_service.dto.ApiResponse;
import com.thangnt.notification_service.dto.requests.SendEmail;
import com.thangnt.notification_service.dto.requests.email.EmailRequest;
import com.thangnt.notification_service.dto.requests.email.Sender;
import com.thangnt.notification_service.dto.responses.EmailResponse;
import com.thangnt.notification_service.repositories.httpclient.EmailClient;
import com.thangnt.notification_service.services.EmailService;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import lombok.experimental.NonFinal;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
@Slf4j
public class EmailServiceImpl implements EmailService {

    EmailClient emailClient;

    @NonFinal
    String apiKey ="apikey";

    @Override
    public ApiResponse<EmailResponse> sendEmail(SendEmail request) {
        EmailRequest emailBody = EmailRequest
                .builder()
                .sender(Sender.builder()
                        .name("ThangNT")
                        .email("nguyenthienthang2002@gmail.com")
                        .build())
                .to(request.getTo())
                .subject(request.getSubject())
                .htmlContent(request.getHtmlContent())
                .build();
        try {
            EmailResponse emailResponse;
            emailResponse = emailClient.sendEmail(apiKey, emailBody);
            return ApiResponse.<EmailResponse>builder()
                    .success(true)
                    .code(201)
                    .data(EmailResponse
                            .builder()
                            .messageId(emailResponse.getMessageId())
                            .build())
                    .build();
        } catch (Exception e) {
            log.error(e.getMessage());
        }
        return null;
    }
}

