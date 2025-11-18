package com.pm.medicalservice.DTO;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class MedicalRecordRequestDTO {
    private String patientId;
    private String doctorId;
    private String diagnosis;
    private String treatment;
    private String date;
}
