package com.pm.appointmentservice.Service;

import com.pm.appointmentservice.DTO.UpdatedStatusDTO;
import com.pm.appointmentservice.Entity.*;
import com.pm.appointmentservice.DTO.AppointmentRequestDTO;
import com.pm.appointmentservice.DTO.AppointmentResponseDTO;
import com.pm.appointmentservice.Exception.AppointmentNotExist;
import com.pm.appointmentservice.Exception.AppointmentStatusExceptionTransition;
import com.pm.appointmentservice.Mapper.AppointmentMapper;
import com.pm.appointmentservice.Repository.AppointmentRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

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

    public List<AppointmentResponseDTO> getAllAppointments(){
        List<Appointment> appointmentList = appointmentRepository.findAll();
        return appointmentList.stream().map(appointmentMapper::toAppointmentResponseDTO).toList();

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
    public List<AppointmentResponseDTO> getappointmentsByPatient(String email){
        if (appointmentRepository.getAppointmentsByPatientEmail(email) == null){
            throw new AppointmentNotExist("this appointment not existed");
        }
        List<Appointment> appointmentList = appointmentRepository.getAppointmentsByPatientEmail(email);
        return appointmentList.stream().map(appointmentMapper::toAppointmentResponseDTO).toList();
    }

    public List<AppointmentResponseDTO> getappointmentsByDoctor(String email){
        if (appointmentRepository.getAppointmentsByDoctorEmail(email) == null){
            throw new AppointmentNotExist("this appointment not existed");
        }
        List<Appointment> appointmentList = appointmentRepository.getAppointmentsByDoctorEmail(email);
        return appointmentList.stream().map(appointmentMapper::toAppointmentResponseDTO).toList();
    }
    public AppointmentResponseDTO updateStatusAppointment(Long id , UpdatedStatusDTO newStatus){
        if(appointmentRepository.getAppointmentById(id) == null){
            throw new AppointmentNotExist("this appointment not existed");
        }
        Appointment appointment = appointmentRepository.getAppointmentById(id);
        validateStatusTransition(appointment.getStatus() , newStatus.getStatus());
        appointment.setStatus(newStatus.getStatus());
        appointmentRepository.save(appointment);
        return appointmentMapper.toAppointmentResponseDTO(appointment);
    }
    private void validateStatusTransition(Status oldStatus, Status newStatus) {
        // Check if status is the same
        if (newStatus == oldStatus) {
            throw new AppointmentStatusExceptionTransition("Status is already " + oldStatus);
        }

        // Define valid transitions
        boolean isValidTransition = false;

        switch (oldStatus) {
            case Status.waiting:
                // From WAITING: can go to CANCELED, STARTED
                isValidTransition = (newStatus == Status.canceled || newStatus == Status.started);
                break;

            case Status.started:
                // From STARTED: can only go to ENDED
                isValidTransition = (newStatus == Status.ended);
                break;

            case Status.ended:
            case Status.canceled:
                // From ENDED or CANCELED: cannot change to anything
                isValidTransition = false;
                break;
        }

        if (!isValidTransition) {
            throw new AppointmentStatusExceptionTransition(
                    String.format("Invalid status transition from %s to %s", oldStatus, newStatus)
            );
        }
    }
}
