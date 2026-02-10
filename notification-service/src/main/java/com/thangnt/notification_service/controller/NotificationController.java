package com.thangnt.notification_service.controller;

import com.thangnt.notification_service.dto.requests.SendEmail;
import com.thangnt.notification_service.dto.requests.email.Recipient;
import com.thangnt.event.NotificationEvent;
import com.thangnt.notification_service.services.EmailService;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@Slf4j
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class NotificationController {

    EmailService emailService;
    @KafkaListener(topics = "notification-delivery")
    public void listenNotificationDelivery(NotificationEvent message){
        log.info("Message received: {}", message);
        emailService.sendEmail(SendEmail.builder()
                .to(List.of(Recipient.builder()
                        .email(message.getRecipient())
                        .name("Recipient name")
                        .build()))
                .subject(message.getSubject())
                .htmlContent(message.getBody())
                .build());
    }


}
