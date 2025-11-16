package com.pm.appointmentservice.Service;

import com.pm.appointmentservice.Entity.Appointment;
import com.pm.appointmentservice.DTO.AppointmentRequestDTO;
import com.pm.appointmentservice.DTO.AppointmentResponseDTO;
import com.pm.appointmentservice.Entity.DoctorClient;
import com.pm.appointmentservice.Entity.PatientClient;
import com.pm.appointmentservice.Mapper.AppointmentMapper;
import com.pm.appointmentservice.Repository.AppointmentRepository;
import lombok.Data;
import org.springframework.stereotype.Service;

import java.sql.Time;
import java.time.LocalDate;
import java.time.LocalTime;

@Service

public class AppointmentService {
    private final AppointmentRepository appointmentRepository;
    private final AppointmentMapper appointmentMapper;
    private final PatientClient patientClient;
    private final DoctorClient doctorClient;

    public AppointmentService(AppointmentRepository appointmentRepository,AppointmentMapper appointmentMapper, PatientClient patientClient, DoctorClient doctorClient) {
        this.appointmentRepository = appointmentRepository;
        this.appointmentMapper = appointmentMapper;
        this.patientClient = patientClient;
        this.doctorClient = doctorClient;
    }

    public AppointmentResponseDTO createAppointment(AppointmentRequestDTO appointmentRequestDTO){



        Appointment appointment = new Appointment();
        appointment.setStartDate(LocalDate.parse(appointmentRequestDTO.getStartDate()));
        appointment.setTime(LocalTime.parse(appointmentRequestDTO.getTime()));
        appointment.setDoctorEmail(appointmentRequestDTO.getDoctorEmail());
        appointment.setPatientEmail(appointmentRequestDTO.getPatientEmail());
        appointment.setStatus(appointmentRequestDTO.getStatus());

        appointmentRepository.save(appointment);

        return appointmentMapper.toAppointmentResponseDTO(appointmentRepository.save(appointment));


    }

}
