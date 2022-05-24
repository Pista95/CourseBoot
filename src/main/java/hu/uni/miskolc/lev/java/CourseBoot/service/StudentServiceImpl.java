package hu.uni.miskolc.lev.java.CourseBoot.service;

import hu.uni.miskolc.lev.java.CourseBoot.persist.StudentRepository;
import hu.uni.miskolc.lev.java.CourseBoot.persist.ProfileRepository;
import hu.uni.miskolc.lev.java.CourseBoot.persist.entity.Profile;
import hu.uni.miskolc.lev.java.CourseBoot.persist.entity.Student;
import org.hibernate.exception.ConstraintViolationException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentServiceImpl implements StudentService{
    private static final Logger logger = LoggerFactory.getLogger(CourseServiceImpl.class);

    private final ProfileRepository profileRepository;
    private final StudentRepository studentRepository;

    @Autowired
    public StudentServiceImpl(StudentRepository studentRepository, ProfileRepository profileRepository) {
        this.studentRepository = studentRepository;
        this.profileRepository = profileRepository;
    }

    @Override
    public void addStudent(Student student) {
        // studentRepository.save(student);
        student = studentRepository.save(student);
        Profile profile = new Profile();
        profile.setStudent(student);
        profileRepository.save(profile);
        System.out.println(lastAddedStudent(student));
    }

    @Override
    public void updateStudent(int student_id, String email, String password) {
        System.out.println("StudentServiceImp update student: "+student_id+" "+email+" "+password);
    }

    @Override
    public void deleteStudent(int student_id) {
        try {
            System.out.println("StudentServiceImpl: delete student "+student_id);
            studentRepository.deleteById(student_id);
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
    public List<Student> getAllStudent() {
        return (List<Student>) studentRepository.findAll();
    }

    public String lastAddedStudent(Student student){
        int last_id=getAllStudent().size()-1;
        return "============== Felvett Tanuló ==============\n" +
                "Tanuló id:"+
                getAllStudent().get(last_id).getStudent_id()+
                "\ne-mail:"+
                getAllStudent().get(last_id).getEmail()+
                "\njelszó:***********\n"+student.toString()+"\n";
    }
}