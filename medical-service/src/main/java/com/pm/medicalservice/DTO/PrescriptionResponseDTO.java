package com.pm.medicalservice.DTO;

import com.pm.medicalservice.Entity.MedicalRecord;
import com.pm.medicalservice.Entity.Medication;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PrescriptionResponseDTO {
    private String prescriptionId;
    private String description;
    private Long medicalRecordId;
    private List<Medication>  medications;
}
