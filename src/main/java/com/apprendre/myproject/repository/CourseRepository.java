package com.apprendre.myproject.repository;

import com.apprendre.myproject.entity.CourseEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface CourseRepository extends JpaRepository<CourseEntity, Long> {

    @Query("SELECT c FROM CourseEntity c WHERE c.courseCode = ?1")
    Optional<CourseEntity> findCourseByCourseCode(String courseCode);
}
