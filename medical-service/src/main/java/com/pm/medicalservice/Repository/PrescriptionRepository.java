package com.pm.medicalservice.Repository;

import com.pm.medicalservice.Entity.Prescription;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PrescriptionRepository extends JpaRepository<Prescription,Long> {
    Prescription getPrescriptionByPrescriptionId(Long prescriptionId);

//    List<Prescription> findByMedicalRecord_id(Long idMedicalrecord);
    //this i created to see if i can fix the problem or not
List<Prescription> findByMedicalRecordIdMedicalrecord(Long idMedicalrecord);
}
