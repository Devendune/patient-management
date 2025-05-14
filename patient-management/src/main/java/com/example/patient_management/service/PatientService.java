package com.example.patient_management.service;

import com.example.patient_management.DTO.PatientResponseDTO;
import com.example.patient_management.Model.Patient;
import com.example.patient_management.mapper.PatientMapper;
import com.example.patient_management.repository.PatientRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PatientService
{
    private PatientRepository patientRepository;

    public PatientService(PatientRepository patientRepository)
    {
        this.patientRepository=patientRepository;
    }

    public List<PatientResponseDTO> getPatients()
    {
        List<Patient> patients=patientRepository.findAll();
        List<PatientResponseDTO>patientResponseDTOS=patients.stream().map(patient -> PatientMapper.toDTO(patient)).toList();
        return patientResponseDTOS;
    }
}
