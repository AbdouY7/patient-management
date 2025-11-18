package com.pm.medicalservice.Mapper;

import com.pm.medicalservice.DTO.MedicalRecordRequestDTO;
import com.pm.medicalservice.DTO.MedicalRecordResponseDTO;
import com.pm.medicalservice.DTO.PrescriptionRequestDTO;
import com.pm.medicalservice.DTO.PrescriptionResponseDTO;
import com.pm.medicalservice.Entity.MedicalRecord;
import com.pm.medicalservice.Entity.Prescription;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.util.UUID;

@Component
public class MedicalMapper {


    public MedicalRecordResponseDTO  medicalRecordToMedicalRecordDTO(MedicalRecord medicalRecord){
        MedicalRecordResponseDTO medicalRecordResponseDTO = new MedicalRecordResponseDTO();
        medicalRecordResponseDTO.setMedicalRecordId(medicalRecord.getIdMedicalrecord().toString());
        medicalRecordResponseDTO.setPatientId(medicalRecord.getPatientId().toString());
        medicalRecordResponseDTO.setDoctorId(medicalRecord.getDoctorId().toString());
        medicalRecordResponseDTO.setDiagnosis(medicalRecord.getDiagnosis());
        medicalRecordResponseDTO.setTreatment(medicalRecord.getTreatment());
        medicalRecordResponseDTO.setPrescriptions(medicalRecord.getPrescriptions().stream().map(this::prescriptionToPrescriptionResponseDTO).toList());
        medicalRecordResponseDTO.setDate(medicalRecord.getDate().toString());

        return medicalRecordResponseDTO;

    }

    public MedicalRecord medicalRecordDTOToMedicalRecord(MedicalRecordRequestDTO medicalRecordRequestDTO){
        MedicalRecord medicalRecord = new MedicalRecord();
    medicalRecord.setPatientId(UUID.fromString(medicalRecordRequestDTO.getPatientId()));
    medicalRecord.setDoctorId(UUID.fromString(medicalRecordRequestDTO.getDoctorId()));
    medicalRecord.setDiagnosis(medicalRecordRequestDTO.getDiagnosis());
    medicalRecord.setTreatment(medicalRecordRequestDTO.getTreatment());
    medicalRecord.setDate(LocalDate.parse(medicalRecordRequestDTO.getDate()));

        return medicalRecord;
    }

    public PrescriptionResponseDTO prescriptionToPrescriptionResponseDTO(Prescription prescription){
        PrescriptionResponseDTO prescriptionResponseDTO = new PrescriptionResponseDTO();
        prescriptionResponseDTO.setPrescriptionId(prescription.getPrescriptionId().toString());
        prescriptionResponseDTO.setDescription(prescription.getDescription());
        prescriptionResponseDTO.setMedicalRecordId(prescription.getMedicalRecord().getIdMedicalrecord());
        prescriptionResponseDTO.setMedications(prescription.getMedication());
        return prescriptionResponseDTO;
    }
    public Prescription prescriptionDTOToPrescription(PrescriptionRequestDTO prescriptionRequestDTO){
        Prescription prescription = new Prescription();
        prescription.setDescription(prescriptionRequestDTO.getDescription());


        return prescription;
    }
}
