package app.controllers;

import app.dtos.AppointmentDTO;
import ch.qos.logback.classic.AsyncAppender;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class AppointmentController
{

    private static List<AppointmentDTO> appointments = new ArrayList(Arrays.asList(
        new AppointmentDTO(1, "regular", "Mike", LocalDateTime.of(2025, 03, 05, 14, 30, 00), LocalDateTime.of(2025, 03, 05, 13, 30, 00),
            2000, "Hannah", "Copenhagen"),
        new AppointmentDTO(2, "advanced", "Hans", LocalDateTime.of(2025, 04, 12, 15, 45, 00), LocalDateTime.of(2025, 04, 12, 16, 00, 00),
            2300, "Malene", "Copenhagen"),
                new AppointmentDTO(3, "advanced", "Laura", LocalDateTime.of(2025, 06, 06, 14, 30, 00), LocalDateTime.of(2025, 06, 06, 15, 00, 00),
            3500, "Sara", "Copenhagen")
    ));

    public AppointmentDTO create(AppointmentDTO appointmentDTO)
    {
        int id = appointments.size() + 1;
        appointmentDTO.setId(id);
        appointments.add(appointmentDTO);
        return appointmentDTO;
    }

    public AppointmentDTO getById(int id)
    {
        try
        {
            return appointments.get(id);
        } catch (Exception e)
        {
            e.printStackTrace();
        }
        return new AppointmentDTO();
    }


    public List<AppointmentDTO> getAll()
    {
        try
        {
            return appointments;
        } catch (Exception e)
        {
            e.printStackTrace();
        }
        return new ArrayList<>();
    }

    public AppointmentDTO update(int id, AppointmentDTO appointmentDTO)
    {
        appointments.set(id, appointmentDTO);
        return appointmentDTO;
    }

    public List<String> getUpcoming()
    {
        try
        {
            return appointments.stream()
                .map(app ->  "Patient: " + app.getPatient()  + " Employee: " + app.getEmployee()  + " Type of treatment: " + app.getTreatment())
                .collect(Collectors.toList());
        } catch (Exception e)
        {
            e.printStackTrace();
        }
        return new ArrayList<>();
    }

    public AppointmentDTO getDetailsById(int id)
    {
        try
        {
            Optional<AppointmentDTO> app = appointments.stream()
                .filter(ap -> ap.getId() == id)
                .findFirst();
            return app.orElse(null);
        } catch (Exception e)
        {
            e.printStackTrace();
            return null;
        }
    }
}
