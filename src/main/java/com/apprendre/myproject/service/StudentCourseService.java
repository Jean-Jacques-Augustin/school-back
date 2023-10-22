package com.apprendre.myproject.service;

import com.apprendre.myproject.entity.CourseEntity;
import com.apprendre.myproject.entity.StudentCourseEntity;
import com.apprendre.myproject.entity.StudentEntity;
import com.apprendre.myproject.repository.CourseRepository;
import com.apprendre.myproject.repository.StudentCourseRepository;
import com.apprendre.myproject.repository.StudentRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Optional;


@Service
public class StudentCourseService {

    private final StudentCourseRepository studentCourseRepository;
    private final StudentRepository studentRepository;
    private final CourseRepository courseRepository;

    @Autowired
    public StudentCourseService(StudentCourseRepository studentCourseRepository, StudentRepository studentRepository, CourseRepository courseRepository) {
        this.studentCourseRepository = studentCourseRepository;
        this.studentRepository = studentRepository;
        this.courseRepository = courseRepository;
    }


    public List<StudentCourseEntity> getAllStudentCourses() {
        return studentCourseRepository.findAll();
    }

    public Optional<StudentCourseEntity> getStudentCourseById(Long id) {
        return studentCourseRepository.findById(id);
    }


    public void deleteStudentCourse(Long id) {
        studentCourseRepository.deleteById(id);
    }

    public StudentCourseEntity enrollStudentToCourse(Long studentId, Long courseId, String grade) {
        StudentEntity student = studentRepository.findById(studentId)
                .orElseThrow(() -> new EntityNotFoundException("Student not found with ID: " + studentId));

        CourseEntity course = courseRepository.findById(courseId)
                .orElseThrow(() -> new EntityNotFoundException("Course not found with ID: " + courseId));

        StudentCourseEntity studentCourse = new StudentCourseEntity();
        studentCourse.setStudent(student);
        studentCourse.setCourse(course);
        studentCourse.setGrade(grade);

        return studentCourseRepository.save(studentCourse);
    }
}
