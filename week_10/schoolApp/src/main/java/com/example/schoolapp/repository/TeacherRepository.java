//package com.example.schoolapp.repository;
//
//import com.example.schoolapp.model.Course;
//import com.example.schoolapp.model.Teacher;
//
//import java.util.ArrayList;
//import java.util.List;
//import java.util.Objects;
//
//public class TeacherRepository {
//
//    private static List<Teacher> teachers = new ArrayList<>();
//    private static List<Teacher> populateArrayList() {
//        List<Teacher> teachers = new ArrayList<>();
//        for (int i = 1; i <= 10; i++) {
//            Teacher teacher = new Teacher(i, "TeacherFirstName" + i, "TeacherLastName" + i, i + 5);
//            teachers.add(teacher);
//        }
//        return teachers;
//    }
//
//    public static List<Teacher> getAllTeachers() {
//        return teachers;
//    }
//
//    public static Teacher getOneTeacher(int id) {
//        return teachers.stream().filter(t -> {
//            return t.getId() == id;
//        }).findFirst().get();
//    }
//
//    public static Teacher getTeacherByName(String name) {
//        return teachers.stream().filter(t -> {
//            return Objects.equals(t.getFirstName(), name);
//        }).findFirst().get();
//    }
//
//
//    public static List<Teacher> addTeacher(Teacher teacher) {
//        teachers.add(teacher);
//        return teachers;
//    }
//
//    public static Teacher updateTeacher(int id, Teacher teacher) {
//        for (Teacher t : teachers) {
//            if (t.getId() == id) {
//                t.setFirstName(teacher.getFirstName());
//                t.setLastName(teacher.getLastName());
//            }
//        }
//        return null;
//    }
//
//    public static boolean deleteTeacher(int id) {
//        List<Teacher> newTeacherList = new ArrayList<>(); // creating list to hold the new list of courses excluding the deleted one
//        Boolean isFound = false;
//
//        for (Teacher t : teachers) {
//            if (t.getId() != id) {
//                newTeacherList.add(t);
//            } else {
//                isFound = true;
//            }
//        }
//        teachers = newTeacherList;
//        return isFound;
//    }
//}
