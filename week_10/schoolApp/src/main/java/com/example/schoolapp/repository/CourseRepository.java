//package com.example.schoolapp.repository;
//
//import com.example.schoolapp.model.Course;
//import com.example.schoolapp.model.Student;
//
//import java.util.ArrayList;
//import java.util.List;
//
//public class CourseRepository {
//
//    private static List<Course> courses = new ArrayList<>(); // empty list to hold courses
//    private static List<Course> populateArrayList() { // populates courses list
//        List<Course> courses = new ArrayList<>();
//        for (int i = 1; i <= 10; i++) {
//            Course course = new Course(i, "Course" + i, i + 5);
//            courses.add(course);
//        }
//        return courses;
//    }
//
//    public static List<Course> getAllCourses() { // returns the list of all courses
//        return courses;
//    }
//
//    public static Course getOneCourse(int id) {
//        return courses.stream().filter(c -> {
//            return c.getId() == id;
//        }).findFirst().get();
//    }
//
//    public static Course getCourseByName(String name) {
//        return courses.stream().filter(c -> {
//            return c.getName() == name;
//        }).findFirst().get();
//    }
//
//    public static List<Course> addCourse(Course course) {
//        courses.add(course);
//        return courses;
//    }
//
//    public static Course updateCourse(int id, Course course) {
//        for (Course c: courses) {
//            if (c.getId() == id) {
//                c.setName(course.getName());
//                c.setTeacherId(course.getTeacherId());
//            }
//        }
//        return null;
//    }
//
//    public static Boolean deleteCourse(int id) {
//        List<Course> newCourseList = new ArrayList<>(); // creating list to hold the new list of courses excluding the deleted one
//        Boolean isFound = false;
//
//        for (Course c : courses) {
//            if (c.getId() != id) {
//                newCourseList.add(c);
//            } else {
//                isFound = true;
//            }
//        }
//        courses = newCourseList;
//        return isFound;
//    }
//}
