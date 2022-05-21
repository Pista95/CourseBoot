package hu.uni.miskolc.lev.java.CourseBoot;

import hu.uni.miskolc.lev.java.CourseBoot.persist.entity.Course;
import hu.uni.miskolc.lev.java.CourseBoot.persist.entity.Student;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class CourseBootApplication {

	public static void main(String[] args) {
		SpringApplication.run(CourseBootApplication.class, args);
	}
}
