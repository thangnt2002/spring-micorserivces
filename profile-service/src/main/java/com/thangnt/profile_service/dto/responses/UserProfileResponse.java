package com.thangnt.profile_service.dto.responses;

import lombok.*;
import lombok.experimental.FieldDefaults;
import lombok.extern.jackson.Jacksonized;

import java.time.LocalDate;

@Data
@Builder
@FieldDefaults(level = AccessLevel.PRIVATE)
public class UserProfileResponse {
    String id;
    String userId;
    String avatar;
    String email;
    String firstName;
    String lastName;
    LocalDate dob;
    String city;
}
