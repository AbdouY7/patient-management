package com.pm.medicalservice.Controller;

import com.pm.medicalservice.DTO.*;
import com.pm.medicalservice.Entity.Medication;
import com.pm.medicalservice.Mapper.MedicalMapper;
import com.pm.medicalservice.Repository.MedicalRecordRepository;
import com.pm.medicalservice.Service.MedicalService;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/medicals")
public class MedicalController {
//    private final MedicalRecordRepository medicalRecordRepository;
//    private final MedicalMapper medicalMapper;
    private final MedicalService medicalService;
    public MedicalController(MedicalRecordRepository medicalRecordRepository, MedicalMapper medicalMapper , MedicalService medicalService){
//        this.medicalRecordRepository = medicalRecordRepository;
//        this.medicalMapper = medicalMapper;
        this.medicalService = medicalService;
    }

    @GetMapping("/all_records")
    public List<MedicalRecordResponseDTO> getAllMedicalRecords(){
        return medicalService.getAllMedicalRecord();
    }

    @GetMapping("/record/{id}")
    public MedicalRecordResponseDTO getMedicalRecordById(@PathVariable("id") Long id){
        return medicalService.getMedicalRecordById(id.toString());
    }

    @PostMapping("/create_record")
    public MedicalRecordResponseDTO  createMedicalRecord(@RequestBody MedicalRecordRequestDTO medicalRecordRequestDTO){
        return medicalService.createMedicalRecord(medicalRecordRequestDTO);
    }
    @GetMapping("/all_prescription")
    public List<PrescriptionResponseDTO> getAllPrescriptions(){
        return medicalService.getAllPrescription();
    }
    @GetMapping("/prescription/{id}")
    public PrescriptionResponseDTO getPrescriptionById(@PathVariable("id") Long id){
        return medicalService.getPrescriptionById(id.toString());
    }
    @PostMapping("/create_prescription/{id}")
    public PrescriptionResponseDTO createPrescription(@PathVariable("id") Long id, @RequestBody PrescriptionRequestDTO prescriptionRequestDTO){
        return medicalService.createPrescription(prescriptionRequestDTO,id);
    }
    @GetMapping("/all_medication")
    public List<Medication> getAllMedications(){
        return medicalService.getAllMedication();
    }
    @GetMapping("/medication/{id}")
    public Medication  getMedicationById(@PathVariable("id") Long id){
        return medicalService.getMedicationById(id.toString());
    }
    @PostMapping("/create_medication")
    public Medication createMedication(@RequestBody MedicationRequestDTO medicationRequestDTO){
        return medicalService.createMedication(medicationRequestDTO);
    }
    @PostMapping("/prescription/{prescriptionId}/add_medication/{medicationId}")
    public PrescriptionResponseDTO addMedicationToPrescription(
            @PathVariable Long prescriptionId,
            @PathVariable Long medicationId) {

        return medicalService.addMedicationToPrescription(prescriptionId, medicationId);
    }

    @GetMapping("/record_by_patient/{id}")
    public List<MedicalRecordResponseDTO> getMedicalRecordByPatient(@PathVariable("id") UUID id){
        return medicalService.getMedicalRecordByPatientId(id);
    }
    @GetMapping("/record_by_doctor/{id}")
    public List<MedicalRecordResponseDTO> getMedicalRecordByDoctor(@PathVariable("id") UUID id){
        return medicalService.getMedicalRecordByDoctorId(id);
    }
}
