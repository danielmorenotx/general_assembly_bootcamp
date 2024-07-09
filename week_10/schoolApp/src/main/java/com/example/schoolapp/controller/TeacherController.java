package com.example.schoolapp.controller;

import com.example.schoolapp.model.Course;
import com.example.schoolapp.model.Student;
import com.example.schoolapp.model.Teacher;
import com.example.schoolapp.service.CourseService;
import com.example.schoolapp.service.TeacherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController // get input and output
public class TeacherController {

    @Autowired
    TeacherService teacherService;

    @GetMapping("/teachers") // turns return into JSON response for HTTP request
    public List<Teacher> getAllTeachers() {
        return teacherService.getAllTeachers();
    }

    @GetMapping("/teachers/{id}")
    public Teacher getOneTeacher(@PathVariable int id) {
        return teacherService.getTeacherById(id);
    }

    @GetMapping(value = "/teachers", params = "name")
    public List<Teacher> getTeacherByName(@RequestParam String name) {
        return teacherService.getTeacherByName(name);
    }

    @PostMapping("/teachers")
    public Teacher addTeacher(@RequestBody Teacher teacher) { // will take a JSON and turn into a Book object
        return teacherService.addTeacher(teacher);
    }

    @PutMapping("/teachers/{id}")
    public Teacher updateTeacher(@PathVariable int id, @RequestBody Teacher teacher) throws Exception {
        return teacherService.updateTeacher(id, teacher);
    }

    @DeleteMapping("/teachers/{id}")
    public void deleteTeacher(@PathVariable int id) {
        teacherService.deleteTeacher(id);
    }

    // ======== COURSES ==========
    @PostMapping("/teachers/{id}/courses")
    public Teacher addCourseToTeacher(@PathVariable Integer id, @RequestBody Course course) throws Exception {
        return teacherService.addCourseToTeacher(id, course);
    }

    @GetMapping("/teachers/{id}/courses")
    public List<Course> getCoursesOfTeacher(@PathVariable Integer id) {
        return teacherService.getTeacherById(id).getCourses();
    }
}
