package com.pm.doctorservice.Mapper;

import com.pm.doctorservice.DTO.DoctorRequestDTO;
import com.pm.doctorservice.DTO.DoctorResponseDTO;
import com.pm.doctorservice.Entity.Doctor;

public class DoctorMapper {

    public static DoctorResponseDTO toDoctorResponseDTO(Doctor doctor) {
        DoctorResponseDTO doctorResponseDTO = new DoctorResponseDTO();
        doctorResponseDTO.setId(doctor.getDoctorId().toString());
        doctorResponseDTO.setName(doctor.getName());
        doctorResponseDTO.setEmail(doctor.getEmail());
        doctorResponseDTO.setPhone(doctor.getPhone());
        doctorResponseDTO.setSpeciality(doctor.getSpeciality());
        return doctorResponseDTO;
    }

    public static Doctor toDoctor(DoctorRequestDTO doctorRequestDTO) {
        Doctor doctor = new Doctor();
        doctor.setName(doctorRequestDTO.getName());
        doctor.setEmail(doctorRequestDTO.getEmail());
        doctor.setPhone(doctorRequestDTO.getPhone());
        doctor.setSpeciality(doctorRequestDTO.getSpeciality());
        return doctor;

    }
}
