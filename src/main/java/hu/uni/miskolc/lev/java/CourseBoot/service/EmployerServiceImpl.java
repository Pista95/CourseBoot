/*
package hu.uni.miskolc.lev.java.CourseBoot.service;
import hu.uni.miskolc.lev.java.CourseBoot.persist.EmployerRepository;
import hu.uni.miskolc.lev.java.CourseBoot.persist.entity.EmployerEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class EmployerServiceImpl implements EmployerService {
    private EmployerRepository employerRepository;

    @Autowired
    public EmployerServiceImpl(EmployerRepository employerRepository) {
        this.employerRepository = employerRepository;
    }

    @Override
    public void AddEmployer(EmployerEntity employerEntity) {
        employerRepository.save(employerEntity);
    }

    @Override
    public void DeleteEmployer(EmployerEntity employerEntity) {
        employerRepository.delete(employerEntity);
    }

    @Override
    public List<EmployerEntity> GetAllEmployer() {
        return (List<EmployerEntity>) employerRepository.findAll();
    }
}

 */