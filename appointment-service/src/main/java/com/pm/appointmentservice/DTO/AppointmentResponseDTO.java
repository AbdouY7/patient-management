package com.pm.appointmentservice.DTO;

import com.pm.appointmentservice.Entity.Status;
import com.pm.appointmentservice.DTO.DoctorResponseDTO;
import com.pm.appointmentservice.DTO.PatientResponseDTO;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.time.LocalTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AppointmentResponseDTO {

    private LocalDate  startDate;
    private LocalTime time;
    private DoctorResponseDTO doctor;
    private PatientResponseDTO patient;
    private Status status;
}
