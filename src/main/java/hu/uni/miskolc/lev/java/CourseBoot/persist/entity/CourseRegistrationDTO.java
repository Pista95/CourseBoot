package hu.uni.miskolc.lev.java.CourseBoot.persist.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CourseRegistrationDTO {

    private long courseregistration_id;

    private int student_id;
    private int course_id;
    // LocalDateTime registeredAt;
    @Min(0)
    @Max(5)
    private int power=0;

}
