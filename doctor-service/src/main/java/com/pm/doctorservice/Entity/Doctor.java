package com.pm.doctorservice.Entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.antlr.v4.runtime.misc.NotNull;

import java.util.UUID;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Doctor {


    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID doctorId;

    @NotNull
    private String doctorName;

    @NotNull
    private String doctorEmail;

    @NotNull
    private String doctorPhone;

    @NotNull
    private String speciality;


}
