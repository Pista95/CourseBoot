package hu.uni.miskolc.lev.java.CourseBoot.controller;

import hu.uni.miskolc.lev.java.CourseBoot.persist.entity.Course;
import hu.uni.miskolc.lev.java.CourseBoot.service.CourseService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;
@Controller
public class CourseController {
    private CourseService courseService;
    public CourseController(CourseService courseService) {
        this.courseService = courseService;
    }
    //Kurzus felvétel
    @PostMapping("addCourse")
    @ResponseBody
    public void addCourse(@RequestBody Course course){
        courseService.addCourse(course);
    }

    @GetMapping("getAllCourse")
    @ResponseBody
    public List<Course> getAllCourse(){
        return courseService.getAllCourse();
    }
}
