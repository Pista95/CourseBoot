package hu.uni.miskolc.lev.java.CourseBoot.service;

import hu.uni.miskolc.lev.java.CourseBoot.model.repo.CourseRegistrationRepository;
import hu.uni.miskolc.lev.java.CourseBoot.model.repo.CourseRepository;
import hu.uni.miskolc.lev.java.CourseBoot.model.repo.StudentRepository;
import hu.uni.miskolc.lev.java.CourseBoot.model.entity.CourseRegistration;
import hu.uni.miskolc.lev.java.CourseBoot.model.entity.CourseRegistrationDTO;
import org.hibernate.exception.ConstraintViolationException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class CourseRegistrationServiceImpl implements CourseRegistrationService {
    private static final Logger logger = LoggerFactory.getLogger(CourseRegistrationServiceImpl.class);
    private final CourseRegistrationRepository courseRegistrationRepository;
    private final CourseRepository courseRepository;
    private final StudentRepository studentRepository;

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
        courseregistration.setRegisteredAt(courseregistrationDTO.getRegisteredAt());
        if(courseRepository.findById(courseregistrationDTO.getCourse_id()).isPresent()) {
            courseregistration.setCourse(courseRepository.findById(courseregistrationDTO.getCourse_id()).get());
        }
        if(studentRepository.findById(courseregistrationDTO.getStudent_id()).isPresent()) {
            courseregistration.setStudent(studentRepository.findById(courseregistrationDTO.getStudent_id()).get());
        }
        courseRegistrationRepository.save(courseregistration);
        System.out.println(lastAddedCourseReg());
    }

    @Override
    public void updateCourseRegistration(CourseRegistrationDTO courseregistrationDTO) {
        //
    }

    /*
    public void deleteCourseRegistration(CourseRegistration courseRegistration){
        courseRegistrationRepository.delete(courseRegistration);
    }
     */
    @Override
    public void deleteCourseRegistration (int course_id) {
        try {
             courseRegistrationRepository.deleteById(course_id);
        } catch (DataIntegrityViolationException e) {
            logger.error("Could not remove course.");
            final Throwable cause = e.getCause();
            if (null != cause && cause instanceof ConstraintViolationException) {
                final ConstraintViolationException cve = (ConstraintViolationException) cause;
                logger.error("Violated constraint: {}", cve.getConstraintName());
            }
            // TODO: throw application exception and handle it by sending http 500
        }
    }

    @Override
    public List<CourseRegistration> getAllCourseRegistration() {
        return (List<CourseRegistration>) courseRegistrationRepository.findAll();
    }

    public String lastAddedCourseReg(){
        int last_id=getAllCourseRegistration().size()-1;
        return "============== Tárgyfelvétel ==============\n" +
                getAllCourseRegistration().get(last_id).getStudent().getProfile().getName()+ " felvette " +
                "a(z) "+getAllCourseRegistration().get(last_id).getCourse().getName() + "kurzust\n" +
                "és az alábbi osztályzatot kapta: "+ getAllCourseRegistration().get(last_id).getPower();
    }
}