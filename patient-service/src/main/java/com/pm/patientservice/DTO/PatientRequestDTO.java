package com.pm.patientservice.DTO;

import com.pm.patientservice.DTO.Validators.CreatePatientValidatorGroup;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PatientRequestDTO {
    @NotBlank(message = "the name is required")
    @Size(max = 100 , message = "name can not exceed 100 characters")
    private String name;

    @NotBlank(message = "Email is required")
    @Email(message = "Email must be valid")
    private String email;

    @NotBlank(message = "Address is required")
    private String address;

    @NotBlank(message = "BirthDay date is required")
    private String dateOfBirth;

    @NotBlank(groups = CreatePatientValidatorGroup.class, message = "Register Date  is required")
    private String registeredDate;

}
