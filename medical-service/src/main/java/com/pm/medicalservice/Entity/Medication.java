package com.pm.medicalservice.Entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotNull;
import lombok.*;



@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Medication {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idmedication;

    @NotNull
    private String medicationName;

    @NotNull
    private String dosage;

    @NotNull
    private String duration;
}