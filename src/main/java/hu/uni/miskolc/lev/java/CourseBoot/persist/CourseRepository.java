package hu.uni.miskolc.lev.java.CourseBoot.persist;

import hu.uni.miskolc.lev.java.CourseBoot.persist.entity.Course;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface CourseRepository extends CrudRepository<Course, Integer> {
    @Query("select c from Course c where c.course_id = ?1")
    CourseRepository findAllByCourse_id(int id);
}