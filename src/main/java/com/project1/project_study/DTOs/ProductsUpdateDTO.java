package com.project1.project_study.DTOs;

import java.math.BigDecimal;

public record ProductsUpdateDTO( String name,
        BigDecimal price,
        String description,
        Long categoryId) {
   }
