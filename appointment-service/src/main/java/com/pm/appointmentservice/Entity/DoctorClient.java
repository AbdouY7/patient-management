package com.pm.appointmentservice.Entity;


import com.pm.appointmentservice.DTO.DoctorResponseDTO;
import com.pm.appointmentservice.DTO.DoctorResponseDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "doctor-service", url = "http://localhost:4001")
public interface DoctorClient {
    @GetMapping("/doctors/{email}")
    DoctorResponseDTO getDoctorByEmail(@PathVariable("email") String email);
}
