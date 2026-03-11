package com.abhi.freecode.dto;

import com.abhi.freecode.entity.School;

public record StudentResponse(
        int id,
    String name,
    String email,
    int age,
        int schoolId

) {
}
