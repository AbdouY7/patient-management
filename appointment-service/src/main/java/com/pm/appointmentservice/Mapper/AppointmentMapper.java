package com.pm.appointmentservice.Mapper;

import com.pm.appointmentservice.Entity.Appointment;
import com.pm.appointmentservice.Entity.DoctorClient;
import com.pm.appointmentservice.Entity.PatientClient;
import com.pm.appointmentservice.DTO.AppointmentResponseDTO;
import com.pm.appointmentservice.DTO.DoctorResponseDTO;
import com.pm.appointmentservice.DTO.PatientResponseDTO;
import lombok.Data;
import org.springframework.stereotype.Component;



@Component
public class AppointmentMapper {
    private final DoctorClient doctorClient;
    private final PatientClient patientClient;
    public AppointmentMapper(DoctorClient doctorClient, PatientClient patientClient) {
        this.doctorClient = doctorClient;
        this.patientClient = patientClient;
    }
    public AppointmentResponseDTO toAppointmentResponseDTO(Appointment appointment){
        DoctorResponseDTO doctorResponseDTO = doctorClient.getDoctorByEmail(appointment.getDoctorEmail());
        PatientResponseDTO patientResponseDTO = patientClient.getPatient(appointment.getPatientEmail());
        AppointmentResponseDTO appointmentResponseDTO = new AppointmentResponseDTO();
        appointmentResponseDTO.setStartDate(appointment.getStartDate());
        appointmentResponseDTO.setTime(appointment.getTime());
        appointmentResponseDTO.setDoctor(doctorResponseDTO);
        appointmentResponseDTO.setPatient(patientResponseDTO);
        appointmentResponseDTO.setStatus(appointment.getStatus());
        return appointmentResponseDTO;

    }

    public Appointment  toAppointment(AppointmentResponseDTO appointmentResponseDTO){
        Appointment appointment = new Appointment();
        appointment.setStartDate(appointmentResponseDTO.getStartDate());
        appointment.setTime(appointmentResponseDTO.getTime());
        appointment.setDoctorEmail(appointmentResponseDTO.getDoctor().getEmail());
        appointment.setPatientEmail(appointmentResponseDTO.getPatient().getEmail());
        appointment.setStatus(appointmentResponseDTO.getStatus());

        return appointment;
    }

}
