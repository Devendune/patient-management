package com.example.patient_management.service;

import com.example.patient_management.DTO.PatientRequestDTO;
import com.example.patient_management.DTO.PatientResponseDTO;
import com.example.patient_management.Model.Patient;
import com.example.patient_management.exceptions.EmailAlreadyExistsException;
import com.example.patient_management.exceptions.PatientNotFoundException;
import com.example.patient_management.mapper.PatientMapper;
import com.example.patient_management.repository.PatientRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.UUID;

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

    public PatientResponseDTO createPatient(PatientRequestDTO patientRequestDTO)
    {
        if(patientRepository.existsByEmail(patientRequestDTO.getEmail()))
        {
            throw new EmailAlreadyExistsException("A patient already exists "+patientRequestDTO.getEmail());
        }
        Patient newPatient=patientRepository.save(PatientMapper.toModel(patientRequestDTO));
        return PatientMapper.toDTO(newPatient);
    }
    public PatientResponseDTO updatePatient(UUID id,PatientRequestDTO patientRequestDTO)
    {
        Patient patient = patientRepository.findById(id).orElseThrow(() -> new PatientNotFoundException("Patient not found with id "+id));
        patient.setAddress(patientRequestDTO.getAddress());
        patient.setEmail(patientRequestDTO.getEmail());
        patient.setName(patientRequestDTO.getName());
        patient.setDateofBirth(LocalDate.parse(patientRequestDTO.getDateOfBirth()));
        patient.setRegisteredDate(LocalDate.parse(patientRequestDTO.getRegisteredDate()));

        return PatientMapper.toDTO(patient);
    }
}
