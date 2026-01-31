package com.thangnt.profile_service.dto.requests;


import lombok.*;
import lombok.experimental.FieldDefaults;
import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class UserProfileRequest {
    String userId;
    String avatar;
    String email;
    String firstName;
    String lastName;
    LocalDate dob;
    String city;
}
