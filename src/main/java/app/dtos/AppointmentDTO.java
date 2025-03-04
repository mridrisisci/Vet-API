package app.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class AppointmentDTO
{
    private Integer id;
    private String treatment;
    private String patient;
    private LocalDateTime sessionBegin;
    private LocalDateTime sessionEnd;
    private Integer price;
    private String employee;
    private String location;

    public AppointmentDTO(String patient, String treatment, LocalDateTime sessionBegin, LocalDateTime sessionEnd, Integer price, String employee, String location)
    {
        this.patient = patient;
        this.treatment = treatment;
        this.sessionBegin = sessionBegin;
        this.sessionEnd = sessionEnd;
        this.price = price;
        this.employee = employee;
        this.location = location;
    }

}
