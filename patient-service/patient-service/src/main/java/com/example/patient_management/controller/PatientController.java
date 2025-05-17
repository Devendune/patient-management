package com.example.patient_management.controller;

import com.example.patient_management.DTO.PatientRequestDTO;
import com.example.patient_management.DTO.PatientResponseDTO;
import com.example.patient_management.Model.Patient;
import com.example.patient_management.service.PatientService;
import jakarta.validation.Valid;
import jakarta.validation.groups.Default;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/patients")
public class PatientController
{
    private PatientService patientService;
    public PatientController(PatientService patientService)
    {
        this.patientService=patientService;
    }

    @GetMapping
    public List<PatientResponseDTO> getPatients()
    {
        List<PatientResponseDTO> patients=patientService.getPatients();
        return patients;
    }

    @PostMapping("/createPatient")
    public ResponseEntity<PatientResponseDTO> createPatient(@Valid @RequestBody PatientRequestDTO patientRequestDTO)
    {
      PatientResponseDTO patientResponseDTO=patientService.createPatient(patientRequestDTO);
      return ResponseEntity.ok().body(patientResponseDTO);
    }

    @PutMapping("/{id}")
    public ResponseEntity<PatientResponseDTO> updatePatient(@PathVariable UUID id, @Validated({Default.class}) @RequestBody PatientRequestDTO patientRequestDTO)
    {
        PatientResponseDTO patientResponseDTO=patientService.updatePatient(id,patientRequestDTO);
        return ResponseEntity.ok().body(patientResponseDTO);
    }

}
