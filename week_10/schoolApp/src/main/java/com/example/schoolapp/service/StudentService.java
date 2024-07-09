package com.example.schoolapp.service;

import com.example.schoolapp.model.Course;
import com.example.schoolapp.model.Student;
import com.example.schoolapp.model.Teacher;
import com.example.schoolapp.repository.ICourseRepository;
import com.example.schoolapp.repository.IStudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service // this is where the business logic goes
public class StudentService {

    @Autowired
    IStudentRepository studentRepository;
    @Autowired
    ICourseRepository courseRepository;

    public List<Student> getAllStudents() {
        return studentRepository.findAll();
    }

    public List<Student> getAllStudentsByName(String name) {
        return studentRepository.findAllByName(name);
    }

    public Student getStudentById(int id) {
        return studentRepository.findById(id).orElse(null);
    }

    public Student addStudent(Student student) {
        return studentRepository.save(student);
    }

    public void deleteStudent(Integer id) {
        studentRepository.deleteById(id);
    }

    public Student updateStudent(Integer id, Student student) throws Exception {
        // first get customer with the id
        Student oldStudent = studentRepository.findById(id).orElse(null);

        if (oldStudent == null) {
            throw new Exception("Student with id " + id + " not found");
        }

        oldStudent.setName(student.getName());
        oldStudent.setEmail(student.getEmail());

        //Model Mapper - auto map properties for us
        return studentRepository.save(oldStudent);
    }

    public Student addCourseToStudent(Integer id, Course course) throws Exception {
        Student existingStudent = studentRepository.findById(id).orElseThrow(() -> new Exception("Student not found"));

        courseRepository.save(course);

        List<Course> courses = existingStudent.getCourses();
        courses.add(course);

        return studentRepository.save(existingStudent);
    }

    public Course getOneCourseOfStudent(int studentId, int courseId) throws Exception {
        Student student = studentRepository.findById(studentId)
                .orElseThrow(() -> new Exception("Student not found"));

        return student.getCourses().stream()
                .filter(c -> c.getId() == courseId)
                .findFirst()
                .orElseThrow(() -> new Exception("No matching course found for student"));
    }

    public void deleteCourseOfStudent(Integer studentId, Integer courseId) throws Exception {
        Student student = studentRepository.findById(studentId)
                .orElseThrow(() -> new Exception("Student not found")); // find the student who has the ID

        List<Course> studentCourses = student.getCourses();
        boolean foundCourse = false;

        for (Course course : studentCourses) {
            if (course.getId() == courseId) {
                studentCourses.remove(course);
                foundCourse = true;
                break;
            }
        }

        if (!foundCourse) {
            throw new Exception("No course matching ID");
        }

        studentRepository.save(student);
    }

    public List<Teacher> getTeachersOfStudentCourse(Integer studentId, Integer courseId) throws Exception {
        Student student = studentRepository.findById(studentId)
                .orElseThrow(() -> new Exception("Student not found"));

        Course course = student.getCourses().stream()
                .filter(c -> c.getId() == courseId)
                .findFirst()
                .orElseThrow(() -> new Exception("Course not found for student"));

        Teacher teacher = course.getTeacher();
        if (teacher == null) {
            throw new Exception("No teacher found for the course");
        }

        List<Teacher> teachers = new ArrayList<>();
        teachers.add(teacher);
        return teachers;
    }

    public Teacher getOneTeacherOfStudentCourse(Integer studentId, Integer courseId, Integer teacherId) throws Exception {
        Student student = studentRepository.findById(studentId)
                .orElseThrow(() -> new Exception("Student not found"));

        Course course = student.getCourses().stream()
                .filter(c -> c.getId() == courseId)
                .findFirst()
                .orElseThrow(() -> new Exception("Course not found for student"));

        Teacher teacher = course.getTeacher();
        if (teacher == null) {
            throw new Exception("No teacher found for the course");
        }

        if (teacher.getId() != teacherId) {
            throw new Exception("Teacher ID does not match");
        }

        return teacher;
    }
}
