/*
package hu.uni.miskolc.lev.java.CourseBoot.controller;
import hu.uni.miskolc.lev.java.CourseBoot.persist.entity.EmployerEntity;
import hu.uni.miskolc.lev.java.CourseBoot.service.EmployerService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import java.util.List;
@Controller
public class EmployerController {
    private EmployerService employerService;

    public EmployerController(EmployerService employerService) {
        this.employerService = employerService;
    }

    @PostMapping("addEmployer")
    @ResponseBody
    public void addEmployer(@RequestBody EmployerEntity employerEntity){
         employerService.AddEmployer(employerEntity);

    }

    @PostMapping("deleteEmployer")
    @ResponseBody
    public void deleteEmployer(@RequestBody EmployerEntity employerEntity){
        employerService.DeleteEmployer(employerEntity);
    }

    @GetMapping("getAllEmployer")
    @ResponseBody
    public List<EmployerEntity> getAllEmployer(){
        return employerService.GetAllEmployer();
    }

}

 */