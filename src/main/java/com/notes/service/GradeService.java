package com.notes.service;

import com.notes.dto.GradeDTO;
import com.notes.model.Grade;
import com.notes.model.Student;
import com.notes.model.Course;
import com.notes.repository.GradeRepository;
import com.notes.repository.StudentRepository;
import com.notes.repository.CourseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
@Transactional
public class GradeService {
    @Autowired
    private GradeRepository gradeRepository;

    @Autowired
    private StudentRepository studentRepository;

    @Autowired
    private CourseRepository courseRepository;

    public List<GradeDTO> getGradesByStudent(Long studentId) {
        return gradeRepository.findByStudentId(studentId).stream()
                .map(this::convertToDTO)
                .collect(Collectors.toList());
    }

    public List<GradeDTO> getGradesByCourse(Long courseId) {
        return gradeRepository.findByCourseId(courseId).stream()
                .map(this::convertToDTO)
                .collect(Collectors.toList());
    }

    public GradeDTO createGrade(GradeDTO gradeDTO) {
        Student student = studentRepository.findById(gradeDTO.getStudentId())
                .orElseThrow(() -> new RuntimeException("Étudiant non trouvé"));
        Course course = courseRepository.findById(gradeDTO.getCourseId())
                .orElseThrow(() -> new RuntimeException("Cours non trouvé"));

        Grade grade = new Grade();
        grade.setValue(gradeDTO.getValue());
        grade.setStudent(student);
        grade.setCourse(course);

        return convertToDTO(gradeRepository.save(grade));
    }

    public GradeDTO updateGrade(Long id, GradeDTO gradeDTO) {
        Grade existingGrade = gradeRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Note non trouvée"));

        existingGrade.setValue(gradeDTO.getValue());
        return convertToDTO(gradeRepository.save(existingGrade));
    }

    public void deleteGrade(Long id) {
        gradeRepository.deleteById(id);
    }

    private GradeDTO convertToDTO(Grade grade) {
        GradeDTO dto = new GradeDTO();
        dto.setId(grade.getId());
        dto.setValue(grade.getValue());
        dto.setStudentId(grade.getStudent().getId());
        dto.setCourseId(grade.getCourse().getId());
        return dto;
    }
} 