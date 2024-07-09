package com.example.schoolapp.controller;

import com.example.schoolapp.model.Course;
import com.example.schoolapp.model.Student;
import com.example.schoolapp.model.Teacher;
import com.example.schoolapp.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController  // system knows this handles the HTTP request
public class StudentController {

    @Autowired
    StudentService studentService; // tells the controller to interact with the service layer, creates a bean

    @GetMapping("/students")
    public List<Student> getAllStudents() {
        return studentService.getAllStudents();
    }

    @GetMapping(value = "/students", params = {"name"})
    public List<Student> getAllStudentByName(@RequestParam String name) { // gets from query
        return studentService.getAllStudentsByName(name);
    }

    @GetMapping("/students/{id}")
    public Student getOneStudent(@PathVariable Integer id) { // gets from URL path
        return studentService.getStudentById(id);
    }

    @PostMapping("/students")
    public Student addStudent(@RequestBody Student student) { // will take a JSON and turn into a Book object
        return studentService.addStudent(student);
    }

    @PutMapping("/students/{id}")
    public Student updateStudent(@PathVariable int id, @RequestBody Student student) throws Exception {
        return studentService.updateStudent(id, student);
    }

    @DeleteMapping("/students/{id}")
    public void deleteStudent(@PathVariable int id) {
        studentService.deleteStudent(id);
    }

// ======= STUDENT COURSES =========
    @PostMapping("/students/{id}/courses")
    public Student addCourseToStudent(@PathVariable Integer id, @RequestBody Course course) throws Exception {
        Student student = studentService.addCourseToStudent(id, course);
        return student;
    }

    @GetMapping("/students/{id}/courses")
    public List<Course> getCoursesOfStudent(@PathVariable Integer id) {
        Student student = studentService.getStudentById(id);
        return student.getCourses();
    }

    @GetMapping("/students/{id}/courses/{courseId}")
    public Course getOneCourseOfStudent(@PathVariable int studentId, @PathVariable int courseId) throws Exception {
        return studentService.getOneCourseOfStudent(studentId, courseId);
    }

    @DeleteMapping("/students/{id}/courses/{courseId}")
    public void deleteCourseOfStudent(@PathVariable Integer studentId, @PathVariable Integer courseId) throws Exception {
        studentService.deleteCourseOfStudent(studentId, courseId);
    }

    @GetMapping("/students/{id}/courses/{courseId}/teachers")
    public List<Teacher> getTeachersOfStudentCourse(@PathVariable Integer studentId, @PathVariable Integer courseId) throws Exception {
        return studentService.getTeachersOfStudentCourse(studentId, courseId);
    }

    @GetMapping("/students/{id}/courses/{courseId}/teachers/{teacherId}")
    public Teacher getOneTeacherOfStudentCourse(@PathVariable Integer studentId, @PathVariable Integer courseId, @PathVariable Integer teacherId) throws Exception {
        return studentService.getOneTeacherOfStudentCourse(studentId, courseId, teacherId);
    }

}
