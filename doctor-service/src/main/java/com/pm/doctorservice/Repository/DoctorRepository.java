package com.pm.doctorservice.Repository;

import com.pm.doctorservice.Entity.Doctor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;


@Repository
public interface DoctorRepository extends JpaRepository<Doctor, UUID> {

boolean existsByDoctorId(UUID doctorId);
boolean existsByDoctorEmail(String email);
boolean existsByDoctorPhone(String phone);

}
