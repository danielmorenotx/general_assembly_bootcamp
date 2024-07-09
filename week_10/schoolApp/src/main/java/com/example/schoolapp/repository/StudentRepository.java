//package com.example.schoolapp.repository;
//
//import com.example.schoolapp.model.Student;
//
//import java.util.ArrayList;
//import java.util.Collections;
//import java.util.List;
//
//public class StudentRepository {
//
//    private static List<Student> students = new ArrayList<>();
//    private static List<Student> populateArrayList() {
//        List<Student> students = new ArrayList<>();
//        for (int i = 1; i <= 10; i++) {
//            Student student = new Student(i, "FirstName" + i, "LastName" + i, "student" + i + "@example.com" );
//            students.add(student);
//        }
//        return students;
//    }
//
//    public static List<Student> getAllStudents() {
//        return students;
//    }
//
//    public static Student getOneStudent(int id) {
//        Student student = students.stream().filter(s -> {
//            return s.getId() == id;
//        }).findFirst().get();
//
//        return student;
//    }
//
//    public static Student getOneStudentByName(String name) {
//        Student student = students.stream().filter(b -> {
//            return b.getFirstName().equals(name);
//        }).findFirst().get();
//
//        return student;
//    }
//
//    public static List<Student> addStudent(Student student) {
//        students.add(student);
//        return students;
//    }
//
//    public static Student updateStudent(int id, Student student) {
//        for (Student s: students) {
//            if (s.getId() == id) {
//                s.setFirstName(student.getFirstName());
//                s.setLastName(student.getLastName());
//                s.setEmail(student.getEmail());
//            }
//        }
//        return null;
//    }
//
//    public static boolean deleteStudent(int id) {
//        List<Student> newStudents = new ArrayList<>();
//        boolean isFound = false;
//
//        for (Student s: students) {
//            if (s.getId() != id) {
//                newStudents.add(s);
//            } else {
//                isFound = true;
//            }
//        }
//        students = newStudents;
//        return isFound;
//    }
//}
