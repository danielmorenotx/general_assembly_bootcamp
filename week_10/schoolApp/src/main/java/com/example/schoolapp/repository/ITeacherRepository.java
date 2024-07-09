package com.example.schoolapp.repository;

import com.example.schoolapp.model.Teacher;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ITeacherRepository extends JpaRepository<Teacher, Integer> {

    List<Teacher> findAllByName(String name);

    List<Teacher> getAllByName(String name);
}
