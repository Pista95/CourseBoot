package hu.uni.miskolc.lev.java.CourseBoot.controller;

import hu.uni.miskolc.lev.java.CourseBoot.persist.entity.Course;
import hu.uni.miskolc.lev.java.CourseBoot.persist.entity.Student;
import hu.uni.miskolc.lev.java.CourseBoot.service.ProfileService;
import hu.uni.miskolc.lev.java.CourseBoot.service.StudentService;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
public class StudentController {
    private final StudentService studentService;
    private final ProfileService profileService;

    public StudentController(StudentService studentService,ProfileService profileService) {
        this.studentService = studentService;
        this.profileService = profileService;
    }

    @PostMapping("addStudent")
    @ResponseBody
    public void addStudent(@RequestBody Student student) {
        studentService.addStudent(student);
       // return student;
    }

    @PostMapping("deleteStudent")
    @ResponseBody
    public void deleteStudent(@RequestBody Student student){
        studentService.deleteStudent(student);
        System.out.println("deleteStudent:"+student.toString());
    }

    @GetMapping("getAllStudentJson")
    @ResponseBody
    public List<Student> getAllStudent(){
        return studentService.getAllStudent();
    }
    @GetMapping(value = "/getAllStudent", produces = MediaType.TEXT_HTML_VALUE)
    @ResponseBody
    public String StudentAsHTML() {
        String result;
        if (studentService.getAllStudent().size() == 0) {
            result= "<html>\n" + "<header><title>getAllstudent</title></header>\n" +
                    "<body>\n" + "Student és a profile táblában nincs rekord!\n" +
                    "</body>\n" + "</html>";
        } else {
             result= "<html><header><title>getAllstudent</title></header><body>";
             result+="Student/Prfile (rekordok száma: " + studentService.getAllStudent().size()+")<br><table align='center' border='1'>" +
                     "<th>Student id</th><th>Student név (profile táblából)</th><th>E-mail</th><!--th>Törlés</th-->";
             for(int i=0; i<studentService.getAllStudent().size(); i++) {
                 result += "<tr><td>"+ studentService.getAllStudent().get(i).getStudent_id()+"</td>" +
                         "<td><input value='"+ profileService.getAllProfile().get(i).getName()+"'></td>"+
                         "<td><input value='"+ studentService.getAllStudent().get(i).getEmail()+"'></td>"+
                         "<td><button onclick='sendJsonToDeleteStudent(this.id)' id='"+ studentService.getAllStudent().get(i).getStudent_id()+"'>Törlés</button></td>";
             }
             result+="<tr><table></body></html>";
        }
        return result;
    }
}