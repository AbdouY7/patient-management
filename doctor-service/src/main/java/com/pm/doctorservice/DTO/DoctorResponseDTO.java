package com.pm.doctorservice.DTO;


import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class DoctorResponseDTO {

    @Id
    private String id;

    private String name;
    private String email;
    private String phone;
    private String speciality;
}
