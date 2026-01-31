package com.thangnt.identity_service.dto.response;

import lombok.Data;

import java.time.LocalDate;
import java.util.Set;

@Data
public class UserCreationResponse {
    String id;
    String firstName;
    String lastName;
    LocalDate dob;
    Set<RoleResponse> roles;
}
