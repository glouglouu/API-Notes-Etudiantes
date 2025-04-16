package com.notes.dto;

import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class GradeDTO {
    private Long id;

    @NotNull(message = "La note est obligatoire")
    @Min(value = 0, message = "La note doit être supérieure ou égale à 0")
    @Max(value = 20, message = "La note doit être inférieure ou égale à 20")
    private Double value;

    @NotNull(message = "L'ID de l'étudiant est obligatoire")
    private Long studentId;

    @NotNull(message = "L'ID du cours est obligatoire")
    private Long courseId;
} 