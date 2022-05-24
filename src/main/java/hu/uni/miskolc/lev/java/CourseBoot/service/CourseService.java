package hu.uni.miskolc.lev.java.CourseBoot.service;

import hu.uni.miskolc.lev.java.CourseBoot.persist.entity.Course;

import java.util.List;

public interface CourseService {
    void addCourse(Course course);
    void updateCourse(int course_id);
    void deleteCourse(int course_id);
    List<Course> getAllCourse();
    String lastAddedCourse();
}