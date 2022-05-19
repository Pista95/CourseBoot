package hu.uni.miskolc.lev.java.CourseBoot.controller;

import hu.uni.miskolc.lev.java.CourseBoot.persist.entity.CourseRegistration;
import hu.uni.miskolc.lev.java.CourseBoot.persist.entity.CourseRegistrationDTO;
import hu.uni.miskolc.lev.java.CourseBoot.service.CourseRegistrationService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
public class CourseRegistrationController {
    private CourseRegistrationService courseRegistrationService;
    public CourseRegistrationController(CourseRegistrationService courseRegistrationService) {
        this.courseRegistrationService =courseRegistrationService;
    }

    @PostMapping("addCourseRegistration")
    @ResponseBody
    public void addCourseRegistration(@RequestBody CourseRegistrationDTO courseregistrationdto){
        courseRegistrationService.addCourseRegistration(courseregistrationdto);
    }


    /*
    @GetMapping("getAllCourseRegistration")
    @ResponseBody
    public List<CourseRegistration> getAllCourseRegistration(){
        return courseRegistrationService.getAllCourseRegistration();
    }
     */




}
