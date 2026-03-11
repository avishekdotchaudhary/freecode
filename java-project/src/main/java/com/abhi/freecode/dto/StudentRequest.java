package com.abhi.freecode.dto;

import jakarta.validation.constraints.NotEmpty;

public record StudentRequest(
        @NotEmpty(message = "First name must not be empty")
    String firstName,
    @NotEmpty(message = "Last name must not be empty")
    String lastName,
    @NotEmpty(message = "Email must not be empty")
    String email,
    int age,
    int schoolId
) {
}
