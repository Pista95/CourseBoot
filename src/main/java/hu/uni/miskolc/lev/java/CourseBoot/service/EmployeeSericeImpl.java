package hu.uni.miskolc.lev.java.CourseBoot.service;

import hu.uni.miskolc.lev.java.CourseBoot.persist.EmployeeRepository;
import hu.uni.miskolc.lev.java.CourseBoot.persist.entity.EmployeeEntity;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class EmployeeSericeImpl implements EmployeeService{
    private EmployeeRepository employeeRepository;
    @Override
    public void hireEmployee(EmployeeEntity employee) {
        employeeRepository.save(employee);
    }

    @Override
    public void fireEmployee(EmployeeEntity employee) {
        employeeRepository.delete(employee);
    }

    @Override
    public List<EmployeeEntity> getAllEmployee() {
        return (List<EmployeeEntity>) employeeRepository.findAll();
    }


    @Override
    public void AddHourToEmployee(int employeeId, int hour) {
        EmployeeEntity employee = employeeRepository.findById(employeeId).get();
        employee.setHourCount(employee.getHourCount()+hour);
        employeeRepository.save(employee);
    }

    @Override
    public List<EmployeeEntity> getEmployeesByEmployerId(int employerId) {
        return null;
    }
}