package com.pm.medicalservice.DTO;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class MedicationRequestDTO {
    private String medicationName;
    private String dosage;
    private String duration;
}
