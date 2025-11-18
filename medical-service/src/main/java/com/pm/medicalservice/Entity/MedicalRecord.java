package com.pm.medicalservice.Entity;


import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.List;
import java.util.UUID;


@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class MedicalRecord {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idMedicalrecord;

    @NotNull
    private UUID patientId;

    @NotNull
    private UUID doctorId;

    @NotNull
    private String diagnosis;

    @NotNull
    private String treatment;

    @NotNull
    private LocalDate date;

    @OneToMany(mappedBy = "medicalRecord" ,  cascade = CascadeType.ALL)
    private List<Prescription> prescriptions;

}
