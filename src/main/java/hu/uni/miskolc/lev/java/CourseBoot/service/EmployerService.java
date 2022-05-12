package hu.uni.miskolc.lev.java.CourseBoot.service;
import hu.uni.miskolc.lev.java.CourseBoot.persist.entity.EmployerEntity;
import java.util.List;
public interface EmployerService {
    void AddEmployer(EmployerEntity employerEntity);
    void DeleteEmployer(EmployerEntity employerEntity);
    List<EmployerEntity> GetAllEmployer();

}