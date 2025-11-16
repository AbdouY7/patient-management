package com.pm.appointmentservice.Entity;


import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.time.LocalTime;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
public class Appointment {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @NotNull
    private LocalDate  startDate;

    @NotNull
    private LocalTime time;

    @NotNull
    @Enumerated(EnumType.STRING)
    private Status status;

    @NotNull
    @Email
    private String doctorEmail;

    @NotNull
    @Email
    private String patientEmail;
}
