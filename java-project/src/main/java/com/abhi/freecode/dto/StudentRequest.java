package com.abhi.freecode.dto;

import jakarta.validation.constraints.NotEmpty;

public record StudentRequest(
        @NotEmpty()
    String firstName,
    @NotEmpty
    String lastName,
    @NotEmpty()
    String email,
    int age

) {
}
