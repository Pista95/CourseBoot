package hu.uni.miskolc.lev.java.CourseBoot.service;

import hu.uni.miskolc.lev.java.CourseBoot.persist.CourseRegistrationRepository;
import hu.uni.miskolc.lev.java.CourseBoot.persist.CourseRepository;
import hu.uni.miskolc.lev.java.CourseBoot.persist.StudentRepository;
import hu.uni.miskolc.lev.java.CourseBoot.persist.entity.CourseRegistration;
import hu.uni.miskolc.lev.java.CourseBoot.persist.entity.CourseRegistrationDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;
@Service
public class CourseRegistrationServiceImpl implements CourseRegistrationService {

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
        System.out.println(lastCourseReg());
    }

    @Override
    public void updateCourseRegistration(CourseRegistrationDTO courseregistrationDTO) {
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
    }


    public String lastCourseReg(){
        int last_id=getAllCourseRegistration().size()-1;
        return "============== Tárgyfelvétel ==============\n" +
                getAllCourseRegistration().get(last_id).getStudent().getProfile().getName()+ " felvette " +
                "a(z) "+getAllCourseRegistration().get(last_id).getCourse().getName() + "kurzust\n" +
                "és az alábbi osztályzatot kapta: "+ getAllCourseRegistration().get(last_id).getPower();
    }

    public void deleteCourseRegistration(CourseRegistration courseRegistration){
        courseRegistrationRepository.delete(courseRegistration);
    }

    @Override
    public List<CourseRegistration> getAllCourseRegistration() {
        return (List<CourseRegistration>) courseRegistrationRepository.findAll();
    }
}