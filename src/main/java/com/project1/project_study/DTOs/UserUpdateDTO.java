package com.project1.project_study.DTOs;
import java.util.Set;

public record UserUpdateDTO(
                            String name,
                            String email,
                            Set<Long> rolesIds,
                            Set<Long> productsIds) {
}
