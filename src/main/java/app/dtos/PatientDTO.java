package app.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class PatientDTO
{
    private int id;
    private String name;
    private int age;
    private String email;
    private String treatmentPlan;

    public PatientDTO(String name, int age, String email, String treatmentPlan)
    {
        this.name = name;
        this.age = age;
        this.email = email;
        this.treatmentPlan = treatmentPlan;
    }
}
