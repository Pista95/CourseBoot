package hu.uni.miskolc.lev.java.CourseBoot.persist;

import hu.uni.miskolc.lev.java.CourseBoot.persist.entity.Course;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface CourseRepository extends CrudRepository<Course, Integer> { }