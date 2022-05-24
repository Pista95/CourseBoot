package hu.uni.miskolc.lev.java.CourseBoot.service;

import hu.uni.miskolc.lev.java.CourseBoot.model.entity.CourseRegistration;
import hu.uni.miskolc.lev.java.CourseBoot.model.entity.CourseRegistrationDTO;

import java.util.List;

public interface CourseRegistrationService {

    void addCourseRegistration(CourseRegistrationDTO courseregistrationDTO);

    void updateCourseRegistration(CourseRegistrationDTO courseregistrationDTO);

    void deleteCourseRegistration(int id);
    List<CourseRegistration> getAllCourseRegistration();
}
