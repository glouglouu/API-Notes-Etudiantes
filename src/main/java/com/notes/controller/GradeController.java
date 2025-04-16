package com.notes.controller;

import com.notes.dto.GradeDTO;
import com.notes.service.GradeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/grades")
public class GradeController {
    @Autowired
    private GradeService gradeService;

    @GetMapping("/student/{studentId}")
    public List<GradeDTO> getGradesByStudent(@PathVariable Long studentId) {
        return gradeService.getGradesByStudent(studentId);
    }

    @GetMapping("/course/{courseId}")
    public List<GradeDTO> getGradesByCourse(@PathVariable Long courseId) {
        return gradeService.getGradesByCourse(courseId);
    }

    @PostMapping
    public GradeDTO createGrade(@RequestBody GradeDTO gradeDTO) {
        return gradeService.createGrade(gradeDTO);
    }

    @PutMapping("/{id}")
    public GradeDTO updateGrade(@PathVariable Long id, @RequestBody GradeDTO gradeDTO) {
        return gradeService.updateGrade(id, gradeDTO);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteGrade(@PathVariable Long id) {
        gradeService.deleteGrade(id);
        return ResponseEntity.ok().build();
    }
} 