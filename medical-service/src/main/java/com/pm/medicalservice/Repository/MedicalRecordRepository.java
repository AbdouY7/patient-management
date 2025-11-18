package com.pm.medicalservice.Repository;

import com.pm.medicalservice.Entity.MedicalRecord;
import com.pm.medicalservice.Entity.Medication;
import com.pm.medicalservice.Entity.Prescription;
import jakarta.validation.constraints.NotNull;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public interface MedicalRecordRepository extends JpaRepository<MedicalRecord,Long> {
    MedicalRecord getMedicalRecordByIdMedicalrecord(Long idMedicalrecord);
    List<MedicalRecord> getMedicalRecordsByDoctorId( UUID doctorId);

    List<MedicalRecord> getMedicalRecordsByPatientId(UUID patientId);


}
