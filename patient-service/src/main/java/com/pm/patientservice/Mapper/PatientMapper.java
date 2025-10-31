package com.pm.patientservice.Mapper;

import com.pm.patientservice.DTO.PatientRequestDTO;
import com.pm.patientservice.DTO.PatientResponseDTO;
import com.pm.patientservice.model.Patient;

import java.time.LocalDate;

public class PatientMapper {
    public static PatientResponseDTO toDTO(Patient p){
        PatientResponseDTO PatientDTO = new PatientResponseDTO();
        PatientDTO.setId(p.getId().toString());
        PatientDTO.setName(p.getName());
        PatientDTO.setEmail(p.getEmail());
        PatientDTO.setAddress(p.getAddress());
        PatientDTO.setBirthDate(p.getBirthDate().toString());
        return PatientDTO;
    }

    public static Patient toPatient(PatientRequestDTO p){
        Patient patient = new Patient();
        patient.setName(p.getName());
        patient.setEmail(p.getEmail());
        patient.setAddress(p.getAddress());
        patient.setBirthDate(LocalDate.parse(p.getDateOfBirth()));
        patient.setRegistrationDate(LocalDate.parse(p.getRegisteredDate()));
        return patient;
    }
}
