package com.example.schoolapp.repository;

import com.example.schoolapp.model.Course;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ICourseRepository extends JpaRepository<Course, Integer> {
    List<Course> findAllByName(String name);
}
