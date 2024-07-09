package com.example.schoolapp.repository;

import com.example.schoolapp.model.Student;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface IStudentRepository extends JpaRepository<Student, Integer> {
    List<Student> findAllByName(String name);
}
