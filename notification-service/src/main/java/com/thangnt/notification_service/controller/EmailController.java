package com.thangnt.notification_service.controller;

import com.thangnt.notification_service.dto.ApiResponse;
import com.thangnt.notification_service.dto.requests.SendEmail;
import com.thangnt.notification_service.dto.responses.EmailResponse;
import com.thangnt.notification_service.services.EmailService;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class EmailController {
    EmailService emailService;

    @PostMapping("/email/send")
    private ApiResponse<EmailResponse> sendEmail(@RequestBody SendEmail request){
        return emailService.sendEmail(request);
    }
}
