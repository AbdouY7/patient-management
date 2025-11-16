package com.pm.patientservice.Service;

import com.pm.patientservice.DTO.PatientRequestDTO;
import com.pm.patientservice.DTO.PatientResponseDTO;
import com.pm.patientservice.Exception.EmailAlreadyExistsException;
import com.pm.patientservice.Exception.PatientNotExistsException;
import com.pm.patientservice.Mapper.PatientMapper;
import com.pm.patientservice.Repository.PatientRepository;
//import com.pm.patientservice.grpc.BillingGrpcServiceClient;
import com.pm.patientservice.grpc.BillingServiceGrpcClient;
import com.pm.patientservice.kafka.KafkaProducer;
import com.pm.patientservice.model.Patient;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class PatientService {
    private final  PatientRepository patientRepository;
    private final BillingServiceGrpcClient billingServiceGrpcClient;
    private final KafkaProducer kafkaProducer;
    public PatientService(PatientRepository patientRepository ,  BillingServiceGrpcClient billingServiceGrpcClient , KafkaProducer kafkaProducer) {
        this.patientRepository = patientRepository;
        this.billingServiceGrpcClient = billingServiceGrpcClient;
        this.kafkaProducer = kafkaProducer;
    }
    public List<PatientResponseDTO> getPatients (){
        List<Patient> patients = patientRepository.findAll();

        return patients.stream().map(PatientMapper::toDTO).toList();
    }

    public PatientResponseDTO createPatient (PatientRequestDTO patientRequestDTO){
        if (patientRepository.existsByEmail(patientRequestDTO.getEmail())) {
            throw new EmailAlreadyExistsException("Patient with this email already exists " + patientRequestDTO.getEmail() );
        }
       Patient newPatient = patientRepository.save(PatientMapper.toPatient(patientRequestDTO));
//        billingGrpcServiceClient.createBillingAccount(newPatient.getId().toString() , newPatient.getName() , newPatient.getEmail() );
        billingServiceGrpcClient.createBillingAccount(newPatient.getId().toString(), newPatient.getName() , newPatient.getEmail()).toBuilder();

        kafkaProducer.sendEvent(newPatient);

        return PatientMapper.toDTO(newPatient);
    }

    public PatientResponseDTO updatePatient (UUID id , PatientRequestDTO patientRequestDTO){

        Patient patient = patientRepository.findById(id).orElseThrow(()-> new PatientNotExistsException("Patient with id " + id + " does not exist"));
        if (patientRepository.existsByEmailAndIdNot(patientRequestDTO.getEmail() , id)) {
            throw new EmailAlreadyExistsException("Patient with this email already exists " + patientRequestDTO.getEmail() );
        }
        patient.setName(patientRequestDTO.getName());
        patient.setEmail(patientRequestDTO.getEmail());
        patient.setAddress(patientRequestDTO.getAddress());
        patient.setBirthDate(LocalDate.parse(patientRequestDTO.getDateOfBirth()));

        Patient updatedPatient = patientRepository.save(patient);
        return PatientMapper.toDTO(updatedPatient);
    }

    public void deletePatient (UUID id ){

        if (!patientRepository.existsById(id)) {
            throw new PatientNotExistsException("Patient with id " + id + " does not exist");
        }

        patientRepository.deleteById(id);
    }

    public PatientResponseDTO getPatient (String email ){
        if(!patientRepository.existsByEmail(email)){
            throw new PatientNotExistsException("Patient with email " + email + " does not exist");
        }
         PatientResponseDTO patientResponseDTO = PatientMapper.toDTO(patientRepository.findByEmail(email));
        return patientResponseDTO;
    }
}
