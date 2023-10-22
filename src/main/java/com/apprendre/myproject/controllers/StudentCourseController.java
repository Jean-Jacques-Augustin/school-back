package com.apprendre.myproject.controllers;

import com.apprendre.myproject.entity.StudentCourseEntity;
import com.apprendre.myproject.service.StudentCourseService;
import lombok.Getter;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;



@RestController
@RequestMapping("/student-course")
public class StudentCourseController {

    @Getter
    @Setter
    public static class EnrollmentRequest {
        private Long studentId;
        private Long courseId;
        private String grade;

        // getters and setters


    }
    private final StudentCourseService studentCourseService;

    @Autowired
    public StudentCourseController(StudentCourseService studentService) {
        this.studentCourseService = studentService;
    }

    @GetMapping
    public List<StudentCourseEntity> getAllStudentCourses() {
        return studentCourseService.getAllStudentCourses();
    }

    @GetMapping("/{id}")
    public ResponseEntity<StudentCourseEntity> getStudentCourseById(@PathVariable Long id) {
        return studentCourseService.getStudentCourseById(id).map(ResponseEntity::ok).orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<StudentCourseEntity> enrollStudent(
            @RequestBody EnrollmentRequest enrollmentRequest

    ) {
        StudentCourseEntity studentCourse = studentCourseService.enrollStudentToCourse(enrollmentRequest.getStudentId(), enrollmentRequest.getCourseId(), enrollmentRequest.getGrade());
        return new ResponseEntity<>(studentCourse, HttpStatus.CREATED);
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteStudentCourse(@PathVariable Long id) {
        studentCourseService.deleteStudentCourse(id);
        return ResponseEntity.ok().build();
    }
}
