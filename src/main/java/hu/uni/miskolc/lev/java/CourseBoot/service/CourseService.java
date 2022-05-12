package hu.uni.miskolc.lev.java.CourseBoot.service;

import hu.uni.miskolc.lev.java.CourseBoot.persist.entity.Course;

import java.util.List;

public interface CourseService {
    void addCourse(Course course);
    void deleteCourse(Course course);
    List<Course> getAllCourse();
}