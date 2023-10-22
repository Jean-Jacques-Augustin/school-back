package com.apprendre.myproject.service;

import com.apprendre.myproject.entity.CourseEntity;
import com.apprendre.myproject.repository.CourseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CourseService {

    private final CourseRepository courseRepository;

    @Autowired
    public CourseService(CourseRepository courseRepository) {
        this.courseRepository = courseRepository;
    }

    public List<CourseEntity> getAllCourses() {
        return courseRepository.findAll();
    }

    public CourseEntity createCourse(CourseEntity course) {
        System.out.println(course.getCourseCode());
        return courseRepository.save(course);
    }


    public CourseEntity updateCourse(Long id, CourseEntity course) {
        Optional<CourseEntity> existingCourse = courseRepository.findById(id);

        if (existingCourse.isPresent()) {
            CourseEntity courseEntity = existingCourse.get();
            courseEntity.setCourseCode(course.getCourseCode());
            courseEntity.setCourseName(course.getCourseName());
            courseEntity.setDescription(course.getDescription());
            courseEntity.setStartDate(course.getStartDate());
            courseEntity.setEndDate(course.getEndDate());

            return courseRepository.save(courseEntity);
        } else {
            return null;
        }
    }

    public void deleteCourse(Long id) {
        Optional<CourseEntity> existingCourse = courseRepository.findById(id);
        if (existingCourse.isPresent()) {
            courseRepository.deleteById(id);
        }
    }
}
