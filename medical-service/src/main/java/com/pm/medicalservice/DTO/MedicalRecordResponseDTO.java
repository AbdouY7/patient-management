package com.pm.medicalservice.DTO;

import com.pm.medicalservice.Entity.Prescription;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class MedicalRecordResponseDTO {

    private String medicalRecordId;
    private String patientId;
    private String doctorId;
    private String diagnosis;
    private String treatment;
    private String date;
    private List<PrescriptionResponseDTO> prescriptions;
}
