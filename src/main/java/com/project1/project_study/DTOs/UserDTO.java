package com.project1.project_study.DTOs;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;

import java.util.Set;

public record UserDTO(
        @NotBlank
        String name,

        @NotBlank
        @Email
        String email,

        @NotEmpty
        Set<Long> rolesIds,

        @NotEmpty
        Set<Long> productsIds

) {
}
