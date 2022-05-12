package hu.uni.miskolc.lev.java.CourseBoot;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import java.math.BigInteger;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class EmployeeDTO {
    private int id;
    @NotBlank
    private String name;
    @Min(18)
    private int age;
    @Min(200000)
    private BigInteger salary;
    @Min(0)
    private int hourCount;
    private int employer_id;
}