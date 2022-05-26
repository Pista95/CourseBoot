package hu.uni.miskolc.lev.java.CourseBoot.controller;

import hu.uni.miskolc.lev.java.CourseBoot.model.entity.Student;
import hu.uni.miskolc.lev.java.CourseBoot.service.ProfileService;
import hu.uni.miskolc.lev.java.CourseBoot.service.StudentService;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

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
    }

    @PostMapping("updateStudent")
    @ResponseBody
    public void updateStudentById(@RequestParam int student_id, @RequestParam String email, @RequestParam String password){
        studentService.updateStudent(student_id, email, password);
    }

    @PostMapping("deleteStudent")
    @ResponseBody
    public void deleteStudent(@RequestParam int student_id){
        studentService.deleteStudent(student_id);
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
             result+="Student/Prfile (rekordok száma: " + studentService.getAllStudent().size()+")<br><table style='width:98%' align='center' border='1'>" +
                     "<th>Tanuló</th><!--th>Tanuló név (id) (profile táblából)</th--><th>E-mail</th><th>Jelszó</th><th colspan='2'>Művelet</th>";
             for(int i=0; i<studentService.getAllStudent().size(); i++) {
                 result += "<tr><td>"+profileService.getAllProfile().get(i).getName()+" (id:"+ studentService.getAllStudent().get(i).getStudent_id()+")</td>" +
                         "<td><input id='email"+studentService.getAllStudent().get(i).getStudent_id()+"' value='"+ studentService.getAllStudent().get(i).getEmail()+"'></td>"+
                         "<td><input type='' id='password"+studentService.getAllStudent().get(i).getStudent_id()+"' value='*********'></td>"+
                         "<td><button onclick='getProfile(this.id)' id='"+ studentService.getAllStudent().get(i).getStudent_id()+"'>Profile</button></td>"+
                         "<!--td><button onclick='updateStudent(this.id)' id='"+ studentService.getAllStudent().get(i).getStudent_id()+"'>Módosít</button></td-->"+
                         "<td><button onclick='deleteStudent(this.id)' id='"+ studentService.getAllStudent().get(i).getStudent_id()+"'>Törlés</button></td>";
             }
             result+="<tr><table></body></html>";
        }
        return result;
    }
}