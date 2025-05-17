package com.example.patient_management.mapper;

import com.example.patient_management.DTO.PatientRequestDTO;
import com.example.patient_management.DTO.PatientResponseDTO;
import com.example.patient_management.Model.Patient;

import java.time.LocalDate;

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

    public static Patient toModel(PatientRequestDTO patientRequestDTO)
    {
        Patient patient=new Patient();
        patient.setAddress(patientRequestDTO.getAddress());
        patient.setEmail(patientRequestDTO.getEmail());
        patient.setName(patientRequestDTO.getName());
        patient.setDateofBirth(LocalDate.parse(patientRequestDTO.getDateOfBirth()));
        patient.setRegisteredDate(LocalDate.parse(patientRequestDTO.getRegisteredDate()));
        return patient;
    }

}
