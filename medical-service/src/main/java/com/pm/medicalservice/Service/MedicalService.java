package com.pm.medicalservice.Service;

import com.pm.medicalservice.DTO.*;
import com.pm.medicalservice.Entity.MedicalRecord;
import com.pm.medicalservice.Entity.Medication;
import com.pm.medicalservice.Entity.Prescription;
import com.pm.medicalservice.Exception.NotExistsException;
import com.pm.medicalservice.Mapper.MedicalMapper;
import com.pm.medicalservice.Repository.MedicalRecordRepository;
import com.pm.medicalservice.Repository.MedicationRepository;
import com.pm.medicalservice.Repository.PrescriptionRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class MedicalService {
    private final MedicalRecordRepository medicalRecordRepository;
    private final PrescriptionRepository prescriptionRepository;
    private final MedicationRepository medicationRepository;
    private final MedicalMapper  medicalMapper;

    public MedicalService(MedicalRecordRepository medicalRecordRepository,PrescriptionRepository prescriptionRepository,MedicationRepository medicationRepository, MedicalMapper  medicalMapper) {
        this.medicalRecordRepository = medicalRecordRepository;
        this.prescriptionRepository = prescriptionRepository;
        this.medicationRepository = medicationRepository;
        this.medicalMapper = medicalMapper;
    }

    public List<MedicalRecordResponseDTO> getAllMedicalRecord(){
        List<MedicalRecord> medicalRecordList = medicalRecordRepository.findAll();

        return medicalRecordList.stream().map(medicalMapper::medicalRecordToMedicalRecordDTO).toList();
    }

    public MedicalRecordResponseDTO getMedicalRecordById(String medicalRecordId)
    {
        if (!medicalRecordRepository.existsById(Long.valueOf(medicalRecordId))){
            throw new NotExistsException("this medical record is not exists");
        }
        MedicalRecord medicalRecord = medicalRecordRepository.getMedicalRecordByIdMedicalrecord(Long.parseLong(medicalRecordId));


        return medicalMapper.medicalRecordToMedicalRecordDTO(medicalRecord);
    }

    public MedicalRecordResponseDTO createMedicalRecord(MedicalRecordRequestDTO medicalRecordRequestDTO)
    {
        MedicalRecord medicalRecord = medicalMapper.medicalRecordDTOToMedicalRecord( medicalRecordRequestDTO);
        MedicalRecord medicalRecordSaved = medicalRecordRepository.save(medicalRecord);
        return medicalMapper.medicalRecordToMedicalRecordDTO(medicalRecordSaved);
    }

    public PrescriptionResponseDTO  getPrescriptionById(String prescriptionId)
    {
        Prescription prescription = prescriptionRepository.getPrescriptionByPrescriptionId(Long.valueOf(prescriptionId));
        return medicalMapper.prescriptionToPrescriptionResponseDTO(prescription);
    }

    public List<PrescriptionResponseDTO> getAllPrescription()
    {
        List<Prescription> prescriptionList = prescriptionRepository.findAll();
        return prescriptionList.stream().map(medicalMapper::prescriptionToPrescriptionResponseDTO).toList();
    }
    public List<PrescriptionResponseDTO> getPrescriptionByMedicalRecordId(Long medicalRecordId)
    {
        List<Prescription> prescriptionList = prescriptionRepository.findByMedicalRecordIdMedicalrecord(medicalRecordId);
        return prescriptionList.stream().map(medicalMapper::prescriptionToPrescriptionResponseDTO).toList();
    }



    public PrescriptionResponseDTO createPrescription(PrescriptionRequestDTO prescriptionRequestDTO , Long medicalRecordId){
        if (!medicalRecordRepository.existsById(medicalRecordId)){
            throw new NotExistsException("this medical record is not exists");
        }
        MedicalRecord medicalRecord = medicalRecordRepository.findById(medicalRecordId).orElse(null);
        Prescription prescription = medicalMapper.prescriptionDTOToPrescription(prescriptionRequestDTO);
        prescription.setMedicalRecord(medicalRecord);
        prescriptionRepository.save(prescription);
        assert medicalRecord != null;
        medicalRecord.getPrescriptions().add(prescription);
        medicalRecordRepository.save(medicalRecord);
        return medicalMapper.prescriptionToPrescriptionResponseDTO(prescription);
    }
    public Medication getMedicationById(String medicationId)
    {
        if (!medicationRepository.existsById(Long.valueOf(medicationId))){
            throw new NotExistsException("this medication is not exists");
        }
        return medicationRepository.getMedicationsByIdmedication(Long.parseLong(medicationId));
    }
    public List<Medication>  getAllMedication()
    {
        return medicationRepository.findAll();
    }
    public Medication createMedication(MedicationRequestDTO medicationRequestDTO)
    {
        Medication medication = new Medication();
        medication.setMedicationName(medicationRequestDTO.getMedicationName());
        medication.setDosage(medicationRequestDTO.getDosage());
        medication.setDuration(medicationRequestDTO.getDuration());
        medicationRepository.save(medication);
        return medication;
    }



    public PrescriptionResponseDTO addMedicationToPrescription(Long prescriptionId, Long medicationId)
    {
        Prescription prescription = prescriptionRepository.getPrescriptionByPrescriptionId(prescriptionId);
        Medication medication = medicationRepository.getMedicationsByIdmedication(medicationId);
        prescription.getMedication().add(medication);
        prescriptionRepository.save(prescription);
        return medicalMapper.prescriptionToPrescriptionResponseDTO(prescription);
    }

    public List<MedicalRecordResponseDTO> getMedicalRecordByPatientId(UUID patientId)
    {
        List<MedicalRecord> medicalRecordsList = medicalRecordRepository.getMedicalRecordsByPatientId(patientId);
        return medicalRecordsList.stream().map(medicalMapper::medicalRecordToMedicalRecordDTO).toList();
    }
    public List<MedicalRecordResponseDTO> getMedicalRecordByDoctorId(UUID doctorId)
    {
        List<MedicalRecord> medicalRecordsList = medicalRecordRepository.getMedicalRecordsByDoctorId(doctorId);
        return medicalRecordsList.stream().map(medicalMapper::medicalRecordToMedicalRecordDTO).toList();
    }
}
