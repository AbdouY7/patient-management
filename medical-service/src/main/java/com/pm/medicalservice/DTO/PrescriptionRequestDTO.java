package com.pm.medicalservice.DTO;

import com.pm.medicalservice.Entity.MedicalRecord;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PrescriptionRequestDTO {
    private String description;
}
