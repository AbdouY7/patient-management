package com.pm.doctorservice.Entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.antlr.v4.runtime.misc.NotNull;

import java.util.UUID;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "doctor", schema = "public")
public class Doctor {


    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID doctorId;

    @NotNull
    private String name;

    @NotNull
    private String email;

    @NotNull
    private String phone;

    @NotNull
    private String speciality;


}
