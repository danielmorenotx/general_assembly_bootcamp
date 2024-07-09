package com.example.schoolapp.service;

import com.example.schoolapp.model.Course;
import com.example.schoolapp.repository.ICourseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CourseService {

    @Autowired
    ICourseRepository courseRepository;

    public List<Course> getAllCourses() {
        return courseRepository.findAll();
    }

    public List<Course> getAllCoursesByName(String name) {
        return courseRepository.findAllByName(name);
    }

    public Course getOneCourse(int id) {
        return courseRepository.findById(id).orElse(null);
    }

    public Course addCourse(Course course) {
        return courseRepository.save(course);
    }

    public void deleteCourse(Integer id) {
        courseRepository.deleteById(id);
    }

    public Course updateCourse(Integer id, Course course) throws Exception {
        // first get customer with the id
        Course oldCourse = courseRepository.findById(id).orElse(null);

        oldCourse.setName(course.getName());

        //Model Mapper - auto map properties for us
        return courseRepository.save(oldCourse);
    }
}
