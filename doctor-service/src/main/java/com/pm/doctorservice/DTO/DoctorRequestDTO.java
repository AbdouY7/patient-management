package com.pm.doctorservice.DTO;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class DoctorRequestDTO {

    @NotBlank(message ="doctor name is requird" )
    @Size(max=100 , message ="name can not exceed 100 characters")
    private String doctorName;
    @NotBlank(message ="doctor email is requird" )
    @Email(message = "Email must be valid")
    private String doctorEmail;

    @NotBlank(message ="doctor phone Number is requird" )
    private String doctorPhone;

    @NotBlank(message ="doctor specialty is requird" )
    private String specialty;
}
