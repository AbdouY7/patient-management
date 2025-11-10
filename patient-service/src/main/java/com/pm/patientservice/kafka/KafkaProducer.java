package com.pm.patientservice.kafka;

import com.pm.patientservice.model.Patient;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;
import patient.event.PatientEvent;

@Slf4j
@Service
public class KafkaProducer {

    private final KafkaTemplate<Object, byte[]> kafkaTemplate;

    public KafkaProducer(KafkaTemplate<Object, byte[]> kafkaTemplate) {
        this.kafkaTemplate = kafkaTemplate;
    }

    public void sendEvent(Patient patient){
        PatientEvent event = PatientEvent.newBuilder()
                .setPatientId(patient.getId().toString())
                .setName(patient.getName())
                .setEmail(patient.getEmail())
                .setEventType("Create Patient")
                .build();
        try{
            kafkaTemplate.send("patient" , event.toByteArray());
        } catch (Exception e) {
            log.error("Error sending Patient created  event: {}", event.toString());
            log.error(e.toString());
        }
    }
}
