package hu.uni.miskolc.lev.java.CourseBoot.persist;

import hu.uni.miskolc.lev.java.CourseBoot.persist.entity.Student;
import org.springframework.data.repository.CrudRepository;

public interface StudentRepository extends CrudRepository<Student, Integer> { }


