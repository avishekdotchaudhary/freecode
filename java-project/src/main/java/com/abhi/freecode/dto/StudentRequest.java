package com.abhi.freecode.dto;

public record StudentRequest(
    String firstName,
    String lastName,
    String email,
    int age
) {
}
