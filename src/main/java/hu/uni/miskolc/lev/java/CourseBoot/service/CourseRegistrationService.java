package hu.uni.miskolc.lev.java.CourseBoot.service;

import hu.uni.miskolc.lev.java.CourseBoot.persist.entity.CourseRegistration;
import hu.uni.miskolc.lev.java.CourseBoot.persist.entity.CourseRegistrationDTO;

import java.util.List;

public interface CourseRegistrationService {
    void addCourseRegistration(CourseRegistrationDTO courseregistrationDTO);
    List<CourseRegistration> getAllCourseRegistration();
}
