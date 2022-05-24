package hu.uni.miskolc.lev.java.CourseBoot.persist.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CourseRegistrationDTO {

    private long courseregistration_id;

    private int student_id=1;

    private int course_id=1;

    private LocalDateTime registeredAt= LocalDateTime.now();

    @Min(0)
    @Max(5)
    private int power=randomPower();

    public int randomPower() {
        List<Integer> givenList = Arrays.asList(3,4,5);
        Random rand = new Random();
        return givenList.get(rand.nextInt(givenList.size()));
    }
}