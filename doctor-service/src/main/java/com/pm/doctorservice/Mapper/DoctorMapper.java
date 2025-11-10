package com.pm.doctorservice.Mapper;

import com.pm.doctorservice.DTO.DoctorRequestDTO;
import com.pm.doctorservice.DTO.DoctorResponseDTO;
import com.pm.doctorservice.Entity.Doctor;

public class DoctorMapper {

    public static DoctorResponseDTO toDoctorResponseDTO(Doctor doctor) {
        DoctorResponseDTO doctorResponseDTO = new DoctorResponseDTO();
        doctorResponseDTO.setId(doctor.getDoctorId().toString());
        doctorResponseDTO.setName(doctor.getDoctorName());
        doctorResponseDTO.setEmail(doctor.getDoctorEmail());
        doctorResponseDTO.setPhone(doctor.getDoctorPhone());
        doctorResponseDTO.setSepeciality(doctor.getSpeciality());
        return doctorResponseDTO;
    }

    public static Doctor toDoctor(DoctorRequestDTO doctorRequestDTO) {
        Doctor doctor = new Doctor();
        doctor.setDoctorName(doctorRequestDTO.getDoctorName());
        doctor.setDoctorEmail(doctorRequestDTO.getDoctorEmail());
        doctor.setDoctorPhone(doctorRequestDTO.getDoctorPhone());
        doctor.setSpeciality(doctorRequestDTO.getSpecialty());
        return doctor;

    }
}
