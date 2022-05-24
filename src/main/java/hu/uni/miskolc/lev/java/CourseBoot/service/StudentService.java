package hu.uni.miskolc.lev.java.CourseBoot.service;

import hu.uni.miskolc.lev.java.CourseBoot.persist.entity.Student;

import java.util.List;

public interface StudentService {
    void addStudent(Student student);
    void updateStudent(int course_id);

    void deleteStudent(int student_id);

    //void deleteStudent(Student student);
     List<Student> getAllStudent();
    String lastAddedStudent(Student student);
}
