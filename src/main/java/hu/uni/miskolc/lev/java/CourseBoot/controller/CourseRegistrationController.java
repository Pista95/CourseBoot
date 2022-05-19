package hu.uni.miskolc.lev.java.CourseBoot.controller;

import hu.uni.miskolc.lev.java.CourseBoot.persist.entity.CourseRegistration;
import hu.uni.miskolc.lev.java.CourseBoot.persist.entity.CourseRegistrationDTO;
import hu.uni.miskolc.lev.java.CourseBoot.service.CourseRegistrationService;
import hu.uni.miskolc.lev.java.CourseBoot.service.CourseService;
import hu.uni.miskolc.lev.java.CourseBoot.service.StudentService;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
public class CourseRegistrationController {
    private CourseRegistrationService courseRegistrationService;
    private StudentService studentService;
    private CourseService courseService;
    public CourseRegistrationController(
            CourseRegistrationService courseRegistrationService,
            StudentService studentService,
            CourseService courseService
    ) {
        this.courseRegistrationService =courseRegistrationService;
        this.studentService=studentService;
        this.courseService=courseService;
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

    @GetMapping(value = "/getAllCourseRegistration", produces = MediaType.TEXT_HTML_VALUE)
    @ResponseBody
    public String CourseRegAsHTML() {
        String result;
        if (courseRegistrationService.getAllCourseRegistration().size() == 0) {
            result= "<html>\n" + "<header><title>getAllCourseAndStudents</title></header>\n" +
                    "<body>\n" + "Még egyetlen tanuló sem vett fel kurzust, " +
                    "kérjük rendelje a tanulókhoz az órarend szerinti kurzus id-ket!\n" +
                    "</body>\n" + "</html>";
        } else {

            result= "<html><header><title>getAllCourseAndStudents</title></header><body>";
            result+="Rekordok száma: " +courseRegistrationService.getAllCourseRegistration().size()+"<br><table border='1'>" +
                    "<th>Sorsz.</th><th>Student id</th><th>Kurzus id</th><th>Jegy</th>";
         for(int i=0; i<courseRegistrationService.getAllCourseRegistration().size(); i++) {
                result += "<tr><td>"+courseRegistrationService.getAllCourseRegistration().get(i).getCourseregistration_id()+"</td>" +
                        "<td>"+courseRegistrationService.getAllCourseRegistration().get(i).getStudent().getStudent_id()+"</td>" +
                        "<td>"+courseRegistrationService.getAllCourseRegistration().get(i).getCourse().getCourse_id()+"</td>" +
                        "<td>"+courseRegistrationService.getAllCourseRegistration().get(i).getPower()+"</td>" +

                        //  "<td><input value='"+courseService.getAllCourse().get(i).getName()+"'></td>" +
                       // "<td><button id='"+courseService.getAllCourse().get(i).getCourse_id()+"'>Törlés</button></td>" +
                        "<br>";
            }
            result+="<tr>\n<table></body></html>";
        }
        return result;
    }




}
