package hu.uni.miskolc.lev.java.CourseBoot.persist;

import hu.uni.miskolc.lev.java.CourseBoot.persist.entity.Student;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface StudentRepository extends CrudRepository<Student, Integer> { }


