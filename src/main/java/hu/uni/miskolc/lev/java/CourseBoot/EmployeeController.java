/*
package hu.uni.miskolc.lev.java.CourseBoot;

import hu.uni.miskolc.lev.java.CourseBoot.persist.entity.EmployeeEntity;
import hu.uni.miskolc.lev.java.CourseBoot.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class EmployeeController {
    @Autowired
    private EmployeeService employeeService;

    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @PostMapping("hireEmployee")
    @ResponseBody

    public void addEmployee(@RequestBody EmployeeEntity employee){
        //Munkavállaló felvétele
        employeeService.hireEmployee(employee);
    }
}

 */