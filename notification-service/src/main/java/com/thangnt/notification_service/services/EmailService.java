package com.thangnt.notification_service.services;

import com.thangnt.notification_service.dto.ApiResponse;
import com.thangnt.notification_service.dto.requests.SendEmail;
import com.thangnt.notification_service.dto.responses.EmailResponse;

public interface EmailService {
    ApiResponse<EmailResponse> sendEmail(SendEmail request);
}
