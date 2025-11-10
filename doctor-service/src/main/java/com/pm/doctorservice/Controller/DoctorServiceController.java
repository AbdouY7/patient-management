package com.pm.doctorservice.Controller;

import com.pm.doctorservice.DTO.DoctorRequestDTO;
import com.pm.doctorservice.DTO.DoctorResponseDTO;
import com.pm.doctorservice.Repository.DoctorRepository;
import com.pm.doctorservice.Services.DoctorService;
import feign.Client;
import jakarta.validation.Valid;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/doctors")
public class DoctorServiceController {
    @Autowired
    private final DoctorRepository doctorRepository;
    private final DoctorService doctorService;

        public DoctorServiceController(DoctorService doctorService, DoctorRepository doctorRepository) {
            this.doctorService = doctorService;
            this.doctorRepository = doctorRepository;
        }

    @GetMapping("/all")
    public ResponseEntity<List<DoctorResponseDTO>> getDoctors() {
        List<DoctorResponseDTO> doctorResponseDTOs = doctorService.getAllDoctors();
        return ResponseEntity.ok().body(doctorResponseDTOs);
    }

    @GetMapping("/doctor/{id}")
    public ResponseEntity<DoctorResponseDTO> getDoctorById(@PathVariable("id") UUID id){
        DoctorResponseDTO doctorResponseDTO = doctorService.getDoctorById(id);
        return ResponseEntity.ok().body(doctorResponseDTO);
    }

    @PostMapping("/createDoctor")
    public ResponseEntity<DoctorResponseDTO> CreateDoctor(@Valid @RequestBody DoctorRequestDTO doctorRequestDTO){

        DoctorResponseDTO doctorResponseDTO =  doctorService.createDoctor(doctorRequestDTO);
        return ResponseEntity.ok().body(doctorResponseDTO);
    }
}
