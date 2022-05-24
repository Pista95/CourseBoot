package hu.uni.miskolc.lev.java.CourseBoot.service;

import hu.uni.miskolc.lev.java.CourseBoot.model.repo.CourseRepository;
import hu.uni.miskolc.lev.java.CourseBoot.model.entity.Course;
import org.hibernate.exception.ConstraintViolationException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CourseServiceImpl implements CourseService{
    private static final Logger logger = LoggerFactory.getLogger(CourseServiceImpl.class);
    private final CourseRepository courseRepository;

    @Autowired
    public CourseServiceImpl(CourseRepository courseRepository) {
        this.courseRepository = courseRepository;
    }

    @Override
    public void addCourse(Course course) {
        courseRepository.save(course);
        System.out.println(lastAddedCourse());
    }

    @Override
    public void updateCourse(int course_id, String name) {
        System.out.println("CourseServiceImpl update course: "+course_id+" course n.:"+name);
        Optional<Course> course = courseRepository.findById(course_id);
        if (course.isPresent()) {
            Course c = course.get();
            c.setName(name);
            courseRepository.save(c);
        }
      /*
        course.ifPresent(c -> {
            c.setName(name);
            courseRepository.save(c);
        });

       */
    }

    @Override
    public void deleteCourse(int id) {
        try {
            courseRepository.deleteById(id);
        } catch (DataIntegrityViolationException e) {
            logger.error("Could not remove course.");
            final Throwable cause = e.getCause();
            if (null != cause && cause instanceof ConstraintViolationException) {
                final ConstraintViolationException cve = (ConstraintViolationException) cause;
                logger.error("Violated constraint: {}", cve.getConstraintName());
            }
            // TODO: throw application exception and handle it by sending http 500
        }
    }

    @Override
    public List<Course> getAllCourse() {
        return (List<Course>) courseRepository.findAll();
    }

    public String lastAddedCourse(){
        int last_id=getAllCourse().size()-1;
        return "============== Új kurzus ==============\n" +
                "Kurzus id:"+
                getAllCourse().get(last_id).getCourse_id()+
                "\nKurzus név:"+
                getAllCourse().get(last_id).getName();
    }


}