package com.project1.project_study.DTOs;

import jakarta.validation.constraints.NotBlank;

public record RolesDTO(
        @NotBlank
        String roles
) {
}
