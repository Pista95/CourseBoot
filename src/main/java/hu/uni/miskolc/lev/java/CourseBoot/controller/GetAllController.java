package hu.uni.miskolc.lev.java.CourseBoot.controller;

import hu.uni.miskolc.lev.java.CourseBoot.service.CourseService;
import hu.uni.miskolc.lev.java.CourseBoot.service.StudentService;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class GetAllController {
    private final StudentService  studentService;
    public GetAllController(StudentService  studentService) {

        this.studentService = studentService;
    }
    @GetMapping(value = "/getAllp", produces = MediaType.TEXT_HTML_VALUE)
    @ResponseBody
    public String welcomeAsHTML() {
    if(studentService.getAllStudent().size()==0){
        return "<html>\n" + "<header><title>getAll</title></header>\n" +
                "<body>\n" + "Student tábla listázása\n Nincs rekord" +
                "</body>\n" + "</html>";
    }else {

        return "<html>\n" + "<header><title>getAll</title></header>\n" +
                "<body>\n" + "Student tábla listázása\n" +
                "</body>\n" + "</html>";
    }
    }
}