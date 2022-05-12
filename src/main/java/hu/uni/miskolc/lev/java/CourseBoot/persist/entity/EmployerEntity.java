package hu.uni.miskolc.lev.java.CourseBoot.persist.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import java.util.List;
@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name= "Employer")
@ToString
public class EmployerEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    @NotBlank
    private String name;
    @Min(1)
    @Max(200)
    private int hourExpectation;
    @OneToMany(mappedBy = "employerEntity")
    private List<EmployeeEntity> employeeList;

}