package com.pm.medicalservice.Repository;

import com.pm.medicalservice.Entity.Medication;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MedicationRepository extends JpaRepository<Medication,Long> {
    Medication getMedicationsByIdmedication(Long idmedication);
}
