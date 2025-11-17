package com.pm.appointmentservice.Repository;

import com.pm.appointmentservice.DTO.AppointmentResponseDTO;
import com.pm.appointmentservice.Entity.Appointment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


import java.util.List;
import java.util.UUID;

@Repository
public interface AppointmentRepository extends JpaRepository<Appointment, Long> {
List<Appointment> getAppointmentsByPatientEmail(String patientEmail);
List<Appointment> getAppointmentsByDoctorEmail(String doctorEmail);
Appointment getAppointmentById(Long id);
}
