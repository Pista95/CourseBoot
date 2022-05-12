package hu.uni.miskolc.lev.java.CourseBoot.service;

import hu.uni.miskolc.lev.java.CourseBoot.persist.entity.CourseRegistration;

import java.util.List;

public interface CourseRegistrationService {
    void addCourseRegistration(CourseRegistration courseregistration);
    List<CourseRegistration> getAllCourseRegistration();
}
