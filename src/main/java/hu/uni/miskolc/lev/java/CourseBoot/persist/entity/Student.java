package hu.uni.miskolc.lev.java.CourseBoot.persist.entity;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.util.Set;

import static javax.persistence.GenerationType.IDENTITY;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Entity
@Table(name = "student")
public class Student {
    @Id
    @GeneratedValue(strategy = IDENTITY)
    private long student_id;

    @NotBlank
    private String email="email";

    @NotBlank
    private String password="password";

    @OneToMany(mappedBy = "student")
    Set<CourseRegistration> courseregistration;

    @OneToOne(mappedBy = "student")
    @PrimaryKeyJoinColumn
    private Profile profile;
}

