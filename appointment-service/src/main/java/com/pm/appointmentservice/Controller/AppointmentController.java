package com.pm.appointmentservice.Controller;

import com.pm.appointmentservice.DTO.AppointmentRequestDTO;
import com.pm.appointmentservice.DTO.AppointmentResponseDTO;
import com.pm.appointmentservice.Entity.Appointment;
import com.pm.appointmentservice.Entity.DoctorClient;
import com.pm.appointmentservice.Entity.PatientClient;
import com.pm.appointmentservice.DTO.UpdatedStatusDTO;
import com.pm.appointmentservice.Mapper.AppointmentMapper;
import com.pm.appointmentservice.Repository.AppointmentRepository;
import com.pm.appointmentservice.Service.AppointmentService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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

    @GetMapping("/all")
    public ResponseEntity<List<AppointmentResponseDTO>> getAllAppointments(){
        List<AppointmentResponseDTO> appointmentResponseDTOList = appointmentService.getAllAppointments();
        return ResponseEntity.ok().body(appointmentResponseDTOList);
    }

    @PostMapping("/createAppointment")
    public ResponseEntity<AppointmentResponseDTO>  createAppointment(@RequestBody AppointmentRequestDTO appointmentRequestDTO){


        AppointmentResponseDTO appointmentResponseDTO =  appointmentService.createAppointment(appointmentRequestDTO);

        return ResponseEntity.ok().body(appointmentResponseDTO);

    }
    @GetMapping("/bypatient/{email}")
    public ResponseEntity<List<AppointmentResponseDTO>>  getAllAppointments(@PathVariable("email") String email){
        return ResponseEntity.ok().body(appointmentService.getappointmentsByPatient(email));
    }

    @GetMapping("/bydoctor/{email}")
    public ResponseEntity<List<AppointmentResponseDTO>> getAllAppointmentsByDoctor(@PathVariable("email") String email){
        return ResponseEntity.ok().body(appointmentService.getappointmentsByDoctor(email));
    }

    @PutMapping("/cancleAppointment/{id}")
    public ResponseEntity<AppointmentResponseDTO>  updateAppointment(@PathVariable("id")  Long id , @RequestBody UpdatedStatusDTO newStatus){
       AppointmentResponseDTO appointmentResponseDTO = appointmentService.updateStatusAppointment(id , newStatus);
        return ResponseEntity.ok().body(appointmentResponseDTO);


    }
}
