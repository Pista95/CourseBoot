package hu.uni.miskolc.lev.java.CourseBoot.persist.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import java.util.Random;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CourseRegistrationDTO {

    private long courseregistration_id;

    private int student_id=1;
    private int course_id=1;
    // LocalDateTime registeredAt;
    @Min(0)
    @Max(5)
    private int power=randomgen();

    public int randomgen() {
        Random rand = new Random();
        int low = 3;
        int high = 5;
        int result = rand.nextInt(high - low) + low;
        return result;
    }

}
