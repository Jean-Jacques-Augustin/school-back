package com.apprendre.myproject.service;

import com.apprendre.myproject.entity.StudentEntity;
import com.apprendre.myproject.repository.StudentRepository;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class StudentService {
    private final StudentRepository studentRepository;

    public StudentService(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    public List<StudentEntity> getStudent() {
        return this.studentRepository.findAll();
    }

    public void addNewStudent(StudentEntity studentEntity) {
        boolean studentExists = this.studentRepository.findStudentByEmail(studentEntity.getEmail()).stream().anyMatch(student -> student.getName().equals(studentEntity.getName()));

        if (studentExists) {
            throw new IllegalStateException("Student already exists");
        } else {
            this.studentRepository.save(studentEntity);
        }
    }

    @Transactional
    public void updateStudent(
            StudentEntity studentEntity
    ) {
        StudentEntity student = this.studentRepository.findById(studentEntity.getId()).orElseThrow(() -> new IllegalStateException("Student with id " + studentEntity.getId() + " does not exist"));

        // update student
        student.setName(studentEntity.getName());
        student.setEmail(studentEntity.getEmail());
        student.setNiveau(studentEntity.getNiveau());

        // save student
        this.studentRepository.save(student);
    }

    public void deleteStudent(Long studentId) {
        boolean studentExists = this.studentRepository.existsById(studentId);

        if (studentExists) {
            this.studentRepository.deleteById(studentId);
        } else {
            throw new IllegalStateException("Student with id " + studentId + " does not exist");
        }
    }
}
