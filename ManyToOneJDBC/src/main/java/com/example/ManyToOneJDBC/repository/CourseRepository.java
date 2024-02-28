package com.example.ManyToOneJDBC.repository;

import com.example.ManyToOneJDBC.entity.Course;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CourseRepository extends JpaRepository<Course, Integer> {
}
