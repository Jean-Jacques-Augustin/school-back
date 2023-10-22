package com.apprendre.myproject.controllers;

import com.apprendre.myproject.entity.CourseEntity;
import com.apprendre.myproject.service.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/course")
public class CourseController {
    private final CourseService courseService;

    @Autowired
    public CourseController(CourseService courseService) {
        this.courseService = courseService;
    }

    @GetMapping
    public List<CourseEntity> getAllCourses() {
        return courseService.getAllCourses();
    }

    @PostMapping
    public CourseEntity createCourse(@RequestBody CourseEntity course) {
        return courseService.createCourse(course);
    }

    @PutMapping("/{id}")
    public CourseEntity updateCourse(@PathVariable Long id, @RequestBody CourseEntity course) {
        return courseService.updateCourse(id, course);
    }

    @DeleteMapping("/{id}")
    public void deleteCourse(@PathVariable Long id) {
        courseService.deleteCourse(id);
    }
}
