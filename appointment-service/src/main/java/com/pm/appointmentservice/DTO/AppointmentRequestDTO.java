package com.pm.appointmentservice.DTO;


import com.pm.appointmentservice.Entity.Status;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.time.LocalTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AppointmentRequestDTO {


    @NotNull
    private String startDate;
    @NotNull
    private String time;

    @NotNull
    private String doctorEmail;
    @NotNull
    private String patientEmail;

    @NotNull
    private Status status;
}
