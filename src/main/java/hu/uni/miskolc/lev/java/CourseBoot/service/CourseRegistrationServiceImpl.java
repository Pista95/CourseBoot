package hu.uni.miskolc.lev.java.CourseBoot.service;

import hu.uni.miskolc.lev.java.CourseBoot.persist.CourseRegistrationRepository;
import hu.uni.miskolc.lev.java.CourseBoot.persist.CourseRepository;
import hu.uni.miskolc.lev.java.CourseBoot.persist.StudentRepository;
import hu.uni.miskolc.lev.java.CourseBoot.persist.entity.CourseRegistration;
import hu.uni.miskolc.lev.java.CourseBoot.persist.entity.CourseRegistrationDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class CourseRegistrationServiceImpl implements CourseRegistrationService {

    private CourseRegistrationRepository courseRegistrationRepository;
    private CourseRepository courseRepository;
    private StudentRepository studentRepository;

    @Autowired
    public CourseRegistrationServiceImpl(CourseRegistrationRepository courseRegistrationRepository,
                                         CourseRepository courseRepository,
                                         StudentRepository studentRepository) {

        this.courseRegistrationRepository = courseRegistrationRepository;
        this.courseRepository=courseRepository;
        this.studentRepository=studentRepository;
    }
    @Override
    public void addCourseRegistration(CourseRegistrationDTO courseregistrationDTO) {

        CourseRegistration courseregistration= new CourseRegistration();
        courseregistration.setPower(courseregistrationDTO.getPower());
        //System.out.println("Kiir:\r\n"+courseregistrationDTO.getPower()+"\r\n");
        //employee.setEmployer(employerRepository.findById(employeeDTO.getEmployer_id()).get());
        courseregistration.setCourse(courseRepository.findById(courseregistrationDTO.getCourse_id()).get());
        courseregistration.setStudent(studentRepository.findById(courseregistrationDTO.getStudent_id()).get());
        courseRegistrationRepository.save(courseregistration);
        System.out.println("Hiba"+courseregistration);
    }

    @Override
    public List<CourseRegistration> getAllCourseRegistration() {
        return (List<CourseRegistration>) courseRegistrationRepository.findAll();
    }
}