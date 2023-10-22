package com.apprendre.myproject.service;

import com.apprendre.myproject.entity.StudentEntity;
import com.apprendre.myproject.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class StudentService {

    private final StudentRepository studentRepository;

    @Autowired
    public StudentService(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    public List<StudentEntity> getAllStudents() {
        return studentRepository.findAll();
    }

    public StudentEntity getStudentById(Long id) {
        Optional<StudentEntity> student = studentRepository.findById(id);
        return student.orElse(null);
    }

    public StudentEntity createStudent(StudentEntity student) {
        return studentRepository.save(student);
    }

    public StudentEntity updateStudent(Long id, StudentEntity updatedStudent) {
        Optional<StudentEntity> existingStudent = studentRepository.findById(id);
        if (existingStudent.isPresent()) {
            StudentEntity student = existingStudent.get();
            student.setFirstName(updatedStudent.getFirstName());
            student.setLastName(updatedStudent.getLastName());
            student.setDateOfBirth(updatedStudent.getDateOfBirth());
            student.setGender(updatedStudent.getGender());
            student.setEmail(updatedStudent.getEmail());
            student.setPhoneNumber(updatedStudent.getPhoneNumber());
            student.setAddress(updatedStudent.getAddress());
            student.setNationality(updatedStudent.getNationality());
            student.setRegistrationDate(updatedStudent.getRegistrationDate());

            return studentRepository.save(student);
        } else {
            return null;
        }
    }

    public void deleteStudent(Long id) {
        studentRepository.deleteById(id);
    }
}
