package com.example.schoolapp.service;

import com.example.schoolapp.model.Course;
import com.example.schoolapp.model.Student;
import com.example.schoolapp.model.Teacher;
import com.example.schoolapp.repository.ICourseRepository;
import com.example.schoolapp.repository.ITeacherRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TeacherService {

    @Autowired
    ITeacherRepository teacherRepository;
    @Autowired
    ICourseRepository courseRepository;

    public List<Teacher> getAllTeachers() {
        return teacherRepository.findAll();
    }

    public List<Teacher> getAllTeachersByName(String name) {
        return teacherRepository.findAllByName(name);
    }

    public Teacher getTeacherById(int id) {
        return teacherRepository.findById(id).orElse(null);
    }

    public List<Teacher> getTeacherByName(String name) {
        return teacherRepository.getAllByName(name);
    }

    public Teacher addTeacher(Teacher teacher) {
        return teacherRepository.save(teacher);
    }

    public void deleteTeacher(Integer id) {
        teacherRepository.deleteById(id);
    }

    public Teacher updateTeacher(Integer id, Teacher teacher) throws Exception {
        // first get customer with the id
        Teacher oldTeacher = teacherRepository.findById(id).orElse(null);

        if (oldTeacher == null) {
            throw new Exception("Student with id " + id + " not found");
        }

        oldTeacher.setName(teacher.getName());
        oldTeacher.setCourseId(teacher.getCourseId());

        //Model Mapper - auto map properties for us
        return teacherRepository.save(oldTeacher);
    }

    public Teacher addCourseToTeacher(Integer id, Course course) throws Exception {
        Teacher existingTeacher = teacherRepository.findById(id)
                .orElseThrow(() -> new Exception("Teacher not found"));

        courseRepository.save(course);

        List<Course> courses = existingTeacher.getCourses();
        courses.add(course);

        return teacherRepository.save(existingTeacher);
    }
}
