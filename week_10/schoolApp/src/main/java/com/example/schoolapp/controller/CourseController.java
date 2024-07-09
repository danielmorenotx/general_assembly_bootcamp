package com.example.schoolapp.controller;

import com.example.schoolapp.model.Course;
import com.example.schoolapp.model.Student;
import com.example.schoolapp.service.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
public class CourseController {

    @Autowired
    CourseService courseService;

    @GetMapping("/courses")
    public List<Course> getAllCourses() {
        return courseService.getAllCourses();
    }

    @GetMapping("/courses/{id}")
    public Course getOneCourse(@PathVariable int id) {
        return courseService.getOneCourse(id);
    }

    @GetMapping(value = "/courses", params = "name")
    public List<Course> getCourseByName(@RequestParam String name) {
        return courseService.getAllCoursesByName(name);
    }

    @PostMapping("/courses")
    public Course createCourse(@RequestBody Course course) { // will take a JSON and turn into a Book object
        return courseService.addCourse(course);
    }

    @PutMapping("/courses/{id}")
    public Course updateCourse(@PathVariable int id, @RequestBody Course course) throws Exception {
        return courseService.updateCourse(id, course);
    }

    @DeleteMapping("/courses/{id}")
    public void deleteCourse(@PathVariable int id) {
        courseService.deleteCourse(id);
    }

}
