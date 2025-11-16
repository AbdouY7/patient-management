package com.pm.appointmentservice.Entity;

import com.pm.appointmentservice.DTO.PatientResponseDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.UUID;

@FeignClient(name = "patient-service", url = "http://localhost:4000")
public interface PatientClient {
    @GetMapping("/patients/{email}")
    PatientResponseDTO getPatient(@PathVariable("email") String email);
}
