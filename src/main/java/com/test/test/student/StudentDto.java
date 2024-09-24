package com.test.test.student;

import jakarta.validation.constraints.NotEmpty;

public record StudentDto(
        @NotEmpty(message = "Name is mandatory")
        String name,
        String email,
        Long scId
) {
}
