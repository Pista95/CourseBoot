package hu.uni.miskolc.lev.java.CourseBoot.controller;

import hu.uni.miskolc.lev.java.CourseBoot.persist.entity.Student;
import hu.uni.miskolc.lev.java.CourseBoot.service.StudentService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
public class StudentController {
    private StudentService studentService;

    public StudentController(StudentService studentService) {
        this.studentService = studentService;

    }

    @PostMapping("addStudent")
    @ResponseBody
    public void addStudent(@RequestBody Student student){
        studentService.addStudent(student);
    }

    @GetMapping("getAllStudent")
    @ResponseBody
    public List<Student> getAllStudent(){
        return studentService.getAllStudent();
    }
}