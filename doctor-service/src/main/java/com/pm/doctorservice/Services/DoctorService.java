package com.pm.doctorservice.Services;


import com.pm.doctorservice.DTO.DoctorRequestDTO;
import com.pm.doctorservice.DTO.DoctorResponseDTO;
import com.pm.doctorservice.Entity.Doctor;
import com.pm.doctorservice.Exception.ExistingDoctorException;
import com.pm.doctorservice.Mapper.DoctorMapper;
import com.pm.doctorservice.Repository.DoctorRepository;
import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Service
@Data
@AllArgsConstructor
public class DoctorService {

    private final DoctorRepository doctorRepository;

    public List<DoctorResponseDTO> getAllDoctors() {
        List<Doctor> doctors = doctorRepository.findAll();
        List<DoctorResponseDTO> doctorResponseDTOs = new ArrayList<>();

        return doctors.stream().map(DoctorMapper::toDoctorResponseDTO).toList();
    }


    public DoctorResponseDTO getDoctorById(UUID id) {
        if (!doctorRepository.existsById(id)) {
            throw new ExistingDoctorException("this doctor is not existed with this id");
        }
        return DoctorMapper.toDoctorResponseDTO(doctorRepository.findById(id).get());
    }

    public DoctorResponseDTO createDoctor(DoctorRequestDTO doctorRequestDTO) {
        if (doctorRepository.existsByEmail(doctorRequestDTO.getEmail()) || doctorRepository.existsByPhone(doctorRequestDTO.getPhone())) {
            throw new ExistingDoctorException("this doctor already exists");
        }
        Doctor newDoctor = DoctorMapper.toDoctor(doctorRequestDTO);
        newDoctor = doctorRepository.save(newDoctor);
        return DoctorMapper.toDoctorResponseDTO(newDoctor);
    }

    public DoctorResponseDTO updateDoctor(UUID id, DoctorRequestDTO doctorRequestDTO) {
        if (!doctorRepository.existsById(id)) {
            throw new ExistingDoctorException("this doctor is not existed");
        }
        Doctor doctor = doctorRepository.findById(id).orElse(null);


        doctor.setName(doctorRequestDTO.getName());
        doctor.setPhone(doctorRequestDTO.getPhone());
        doctor.setEmail(doctorRequestDTO.getEmail());
        doctor.setSpeciality(doctorRequestDTO.getSpeciality());

        doctorRepository.save(doctor);

        return DoctorMapper.toDoctorResponseDTO(doctor);


    }


    public void deleteDoctor(UUID id) {
        if (!doctorRepository.existsById(id)) {
            throw new ExistingDoctorException("this doctor is not existed");
        }
        doctorRepository.deleteById(id);
    }


}
