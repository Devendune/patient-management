package com.example.patient_management.kafka;

import com.example.patient_management.Model.Patient;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

import java.util.Locale;

@Service
public class KafkaProducer
{
private final KafkaTemplate<String,byte[]>kafkaTemplate;

    public KafkaProducer(KafkaTemplate<String, byte[]> kafkaTemplate) {
        this.kafkaTemplate = kafkaTemplate;
    }

    public void sendEvetn(Patient patient)
    {
        PatientEvent event=new PatientEvent.Builder()
                .setPatientId(patient.getId().toString())
                .setName(patient.getName())
                .setEmail(patient.getEmail())
                .build();

        try {
            kafkaTemplate.send("patient", event.toByteArray());
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

    }
}
