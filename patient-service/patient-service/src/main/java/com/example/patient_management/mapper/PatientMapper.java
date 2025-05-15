package com.example.patient_management.mapper;

import com.example.patient_management.DTO.PatientResponseDTO;
import com.example.patient_management.Model.Patient;

public class PatientMapper
{
    public static PatientResponseDTO toDTO(Patient patient)
    {
        PatientResponseDTO patientResponseDTO=new PatientResponseDTO();
        patientResponseDTO.setAddress(patient.getAddress());
        patientResponseDTO.setEmail(patient.getEmail());
        patientResponseDTO.setId(patient.getId().toString());
        patientResponseDTO.setName(patient.getName());
        patientResponseDTO.setDateOfBirth(patient.getDateofBirth().toString());

        return patientResponseDTO;
    }
}
