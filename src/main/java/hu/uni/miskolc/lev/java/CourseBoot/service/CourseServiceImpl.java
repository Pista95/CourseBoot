package hu.uni.miskolc.lev.java.CourseBoot.service;

import hu.uni.miskolc.lev.java.CourseBoot.persist.CourseRepository;
import hu.uni.miskolc.lev.java.CourseBoot.persist.entity.Course;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CourseServiceImpl implements CourseService{
    private CourseRepository courseRepository;

    @Autowired
    public CourseServiceImpl(CourseRepository courseRepository) {
        this.courseRepository = courseRepository;
    }
    @Override
    public void addCourse(Course course) {
        courseRepository.save(course);
        System.out.println(lastCourse());
    }
    public String lastCourse(){
        int last_id=getAllCourse().size()-1;
        return "============== Új kurzus ==============\n" +
                "Kurzus id:"+
                getAllCourse().get(last_id).getCourse_id()+
                "\nKurzus név:"+
                getAllCourse().get(last_id).getName();
    }
    @Override
    public void deleteCourse(Course course) {
        courseRepository.delete(course);
    }
    @Override
    public void deleteCourseById(int course_id) {
        // TODO Auto-generated method stub
        courseRepository.deleteById(course_id);
    }

    @Override
    public List<Course> getAllCourse() {
        return (List<Course>) courseRepository.findAll();
    }
}
