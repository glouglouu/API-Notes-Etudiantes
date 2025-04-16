package com.notes.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Data;
import java.util.List;

@Entity
@Table(name = "courses")
@Data
public class Course {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "Le nom du cours est obligatoire")
    @Size(min = 2, max = 100, message = "Le nom du cours doit contenir entre 2 et 100 caractères")
    private String name;

    @NotBlank(message = "Le code du cours est obligatoire")
    @Size(min = 2, max = 20, message = "Le code du cours doit contenir entre 2 et 20 caractères")
    @Column(unique = true)
    private String code;

    @OneToMany(mappedBy = "course", cascade = CascadeType.ALL)
    private List<Grade> grades;
} 