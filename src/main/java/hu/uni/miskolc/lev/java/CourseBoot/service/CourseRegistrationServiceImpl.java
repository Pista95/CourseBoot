package hu.uni.miskolc.lev.java.CourseBoot.service;

import hu.uni.miskolc.lev.java.CourseBoot.persist.CourseRegistrationRepository;
import hu.uni.miskolc.lev.java.CourseBoot.persist.entity.CourseRegistration;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class CourseRegistrationServiceImpl implements CourseRegistrationService {

    private CourseRegistrationRepository courseRegistrationRepository;

    @Autowired
    public CourseRegistrationServiceImpl(CourseRegistrationRepository courseRegistrationRepository) {

        this.courseRegistrationRepository = courseRegistrationRepository;
    }
    @Override
    public void addCourseRegistration(CourseRegistration courseregistration) {
        courseRegistrationRepository.save(courseregistration);
    }

    @Override
    public List<CourseRegistration> getAllCourseRegistration() {
        return (List<CourseRegistration>) courseRegistrationRepository.findAll();
    }
}