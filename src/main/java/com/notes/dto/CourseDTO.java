package com.notes.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
public class CourseDTO {
    private Long id;

    @NotBlank(message = "Le nom du cours est obligatoire")
    @Size(min = 2, max = 100, message = "Le nom du cours doit contenir entre 2 et 100 caractères")
    private String name;

    @NotBlank(message = "Le code du cours est obligatoire")
    @Size(min = 2, max = 20, message = "Le code du cours doit contenir entre 2 et 20 caractères")
    private String code;
} 