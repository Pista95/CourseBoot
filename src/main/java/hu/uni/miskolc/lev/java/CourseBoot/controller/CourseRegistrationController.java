package hu.uni.miskolc.lev.java.CourseBoot.controller;

import hu.uni.miskolc.lev.java.CourseBoot.persist.entity.CourseRegistration;
import hu.uni.miskolc.lev.java.CourseBoot.persist.entity.CourseRegistrationDTO;
import hu.uni.miskolc.lev.java.CourseBoot.service.CourseRegistrationService;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
public class CourseRegistrationController {
    private final CourseRegistrationService courseRegistrationService;

    public CourseRegistrationController( CourseRegistrationService courseRegistrationService) {
        this.courseRegistrationService =courseRegistrationService;
    }

    @PostMapping("addCourseRegistration")
    @ResponseBody
    public void addCourseRegistration(@RequestBody CourseRegistrationDTO courseregistrationdto){
        courseRegistrationService.addCourseRegistration(courseregistrationdto);
    }
    @PostMapping("updateCourseRegistration")
    @ResponseBody
    public void updateCourseRegistration(@RequestBody CourseRegistrationDTO courseregistrationdto){
        courseRegistrationService.updateCourseRegistration(courseregistrationdto);
    }
    @PostMapping("update")
    @ResponseBody
    public void update(@RequestBody String p){
       // return p;
    }



    @PostMapping("deleteCourseRegistration")
    @ResponseBody
    public void deleteCourseRegistration(@RequestBody CourseRegistration courseRegistration){
       courseRegistrationService.deleteCourseRegistration(courseRegistration);
    }

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
            result+="Kurzus fevétel, kapcsoló tábla (rekordok száma: " +courseRegistrationService.getAllCourseRegistration().size()+")<table align='center' border='1'>" +
                    "<th>Sorsz.</th><th>Student név (id)</th><th>Kurzus név (id)</th><th>Jegy</th><!--th>Jegybeírás</th--><th>Töröl</th>";
         for(int i=0; i<courseRegistrationService.getAllCourseRegistration().size(); i++) {
                result += "<tr><td>"+courseRegistrationService.getAllCourseRegistration().get(i).getCourseregistration_id()+"</td>" +
                        "<td>"+courseRegistrationService.getAllCourseRegistration().get(i).getStudent().getProfile().getName() +
                        "(" +courseRegistrationService.getAllCourseRegistration().get(i).getStudent().getStudent_id()+")</td>" +
                        "<td>"+courseRegistrationService.getAllCourseRegistration().get(i).getCourse().getName() +
                        "("+courseRegistrationService.getAllCourseRegistration().get(i).getCourse().getCourse_id()+")</td>" +
                        "<td><input id='inp"+courseRegistrationService.getAllCourseRegistration().get(i).getCourseregistration_id()+"\'" +
                        "value='"+courseRegistrationService.getAllCourseRegistration().get(i).getPower()+"'/>" +
                        //"<button onclick=\"update(this.id, document.getElementById('inp"+courseRegistrationService.getAllCourseRegistration().get(i).getCourseregistration_id()+"').value)\" id='"+courseRegistrationService.getAllCourseRegistration().get(i).getCourseregistration_id()+"'>Update</button></td>"+
                        "<a target='p' href='http://localhost:8090/update?id=1&power=4'>Update</a>"+
                        "<td><button onclick='sendJsonToDeleteCourseReg(this.id)' id='"+courseRegistrationService.getAllCourseRegistration().get(i).getCourseregistration_id()+"'>Töröl</button></td>";
            }
            result+="<tr><table>" +
                    "<iframe id='p' name='p'></iframe>" +
                    "</body></html>";
        }
        return result;
    }
}