package hu.uni.miskolc.lev.java.CourseBoot.persist.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ProfileDTO {
    private int profile_id;

    private String name;

    private int age;

    private int student_id;
}
