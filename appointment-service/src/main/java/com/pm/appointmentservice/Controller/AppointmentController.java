package com.pm.appointmentservice.Controller;

import com.pm.appointmentservice.DTO.AppointmentRequestDTO;
import com.pm.appointmentservice.DTO.AppointmentResponseDTO;
import com.pm.appointmentservice.Entity.Appointment;
import com.pm.appointmentservice.Entity.DoctorClient;
import com.pm.appointmentservice.Entity.PatientClient;
import com.pm.appointmentservice.Mapper.AppointmentMapper;
import com.pm.appointmentservice.Repository.AppointmentRepository;
import com.pm.appointmentservice.Service.AppointmentService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/appointments")
public class AppointmentController {
    private final AppointmentRepository appointmentRepository;
    private final AppointmentService  appointmentService;
    private final PatientClient patientClient;
    private final DoctorClient doctorClient;
    private final AppointmentMapper appointmentMapper;

    public AppointmentController(AppointmentRepository appointmentRepository , AppointmentMapper appointmentMapper, PatientClient patientClient, DoctorClient doctorClient , AppointmentService  appointmentService) {
        this.appointmentRepository = appointmentRepository;

        this.appointmentMapper = appointmentMapper;
        this.patientClient = patientClient;
        this.doctorClient = doctorClient;
        this.appointmentService  = appointmentService;
    }

    @PostMapping("/createAppointment")
    public ResponseEntity<AppointmentResponseDTO>  createAppointment(@RequestBody AppointmentRequestDTO appointmentRequestDTO){


        AppointmentResponseDTO appointmentResponseDTO =  appointmentService.createAppointment(appointmentRequestDTO);

        return ResponseEntity.ok().body(appointmentResponseDTO);

    }
}
