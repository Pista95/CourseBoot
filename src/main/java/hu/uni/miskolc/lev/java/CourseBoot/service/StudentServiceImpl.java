package hu.uni.miskolc.lev.java.CourseBoot.service;

import hu.uni.miskolc.lev.java.CourseBoot.persist.StudentRepository;
import hu.uni.miskolc.lev.java.CourseBoot.persist.ProfileRepository;
import hu.uni.miskolc.lev.java.CourseBoot.persist.entity.Profile;
import hu.uni.miskolc.lev.java.CourseBoot.persist.entity.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentServiceImpl implements StudentService{
    private ProfileRepository profileRepository;
    private static StudentRepository studentRepository;

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
        //System.out.println("Profile obj.:"+profile);

        System.out.println(lastStudent());
    }

    public String lastStudent(){
        int last_id=getAllStudent().size()-1;
        return "============== Felvett Tanuló ==============\n" +
                "Tanuló id:"+
                getAllStudent().get(last_id).getStudent_id()+
                "\ne-mail:"+
                getAllStudent().get(last_id).getEmail()+
                "\njelszó:***********";
    }
    /*
    public void tanulokListazasa(){
        //return StudentService.getAllStudent().toString();
        System.out.println("============== Felvett Tanuló ==============");
        for (int i = getAllStudent().size()-1; i < getAllStudent().size(); i++) {
            System.out.println(
                    "Tanuló id: "+getAllStudent().get(i).getStudent_id()
                            +"\nE-mail: "+getAllStudent().get(i).getEmail()
                            +"\nJelszó: "+getAllStudent().get(i).getPassword()+"\n"
            );
        }

        System.out.println("============== Összes Tanuló ==============");
        for (int i =0; i < getAllStudent().size(); i++) {
            System.out.println(
                    "Tanuló id: "+getAllStudent().get(i).getStudent_id()
                            +"\nE-mail: "+getAllStudent().get(i).getEmail()
                            +"\nJelszó: "+getAllStudent().get(i).getPassword()+"\n"
            );
        }


    }

     */

    public List<Student> getAllStudent() {

        return (List<Student>) studentRepository.findAll();
    }
}