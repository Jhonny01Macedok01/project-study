package com.project1.project_study.DTOs;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.math.BigDecimal;

public record ProductsDTO(
       @NotBlank
        String name,

        @NotNull
        BigDecimal price,

        @NotBlank
        String description,

        @NotNull
        Long categoryId
) {
}
