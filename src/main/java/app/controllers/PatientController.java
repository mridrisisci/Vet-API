package app.controllers;

import app.dtos.PatientDTO;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class PatientController
{

    private static List<PatientDTO> patients = new ArrayList(Arrays.asList(
        new PatientDTO(1, "Lorenzo", 20, "lorenzo@example.com", "regular"),
        new PatientDTO(2, "Melissa", 22, "melissa@example.com", "advanced"),
        new PatientDTO(3, "Anna", 30, "anna@example.com", "medium"))
    );

    public PatientDTO create(PatientDTO patientDTO)
    {
        int id = patients.size() + 1;
        patientDTO.setId(id);
        patients.add(patientDTO);
        return patientDTO;
    }

    public PatientDTO getById(int id)
    {
        try
        {
            return patients.get(id);
        } catch (Exception e)
        {
            e.printStackTrace();
        }
        return patients.get(id);
    }


    public List<PatientDTO> getAll()
    {
        try
        {
            return patients;
        } catch (Exception e)
        {
            e.printStackTrace();
        }
        return new ArrayList<>();
    }

    public PatientDTO update(int id, PatientDTO patientDTO)
    {
        patients.set(id, patientDTO);
        return patientDTO;
    }


    public PatientDTO getDetailsById(int id)
    {
        try
        {
            Optional<PatientDTO> app = patients.stream()
                .filter(ap -> ap.getId() == id)
                .findFirst();
            return app.orElse(null);
        } catch (Exception e)
        {
            e.printStackTrace();
            return null;
        }
    }

    public PatientDTO addPatient(PatientDTO dto)
    {
        try
        {
            int id = patients.size() + 1;
            dto.setId(id);
            patients.add(dto);
            return dto;
        } catch (Exception e)
        {
            e.printStackTrace();
            return null;
        }
    }
}
