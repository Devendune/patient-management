package com.example.patient_management.controller;

import com.example.patient_management.DTO.PatientRequestDTO;
import com.example.patient_management.DTO.PatientResponseDTO;
import com.example.patient_management.DTO.validators.CreatePatientValidationGroup;
import com.example.patient_management.service.PatientService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.groups.Default;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/patients")
@Tag(name="Patients" ,description="This is a project for managing Patients")

public class PatientController
{
    private PatientService patientService;
    public PatientController(PatientService patientService)
    {
        this.patientService=patientService;
    }

    @GetMapping
    @Operation(summary = "Get Patients")
    public List<PatientResponseDTO> getPatients()
    {
        List<PatientResponseDTO> patients=patientService.getPatients();
        return patients;
    }

    @PostMapping("/createPatient")
    @Operation(summary = "Creating Patients")
    public ResponseEntity<PatientResponseDTO> createPatient(@Validated({Default.class, CreatePatientValidationGroup.class}) @RequestBody PatientRequestDTO patientRequestDTO)
    {
      PatientResponseDTO patientResponseDTO=patientService.createPatient(patientRequestDTO);
      return ResponseEntity.ok().body(patientResponseDTO);
    }

    @PutMapping("/updatePatient/{id}")
    @Operation(summary = "Updating Patients")
    public ResponseEntity<PatientResponseDTO> updatePatient(@PathVariable UUID id, @Validated({Default.class}) @RequestBody PatientRequestDTO patientRequestDTO)
    {
        PatientResponseDTO patientResponseDTO=patientService.updatePatient(id,patientRequestDTO);
        return ResponseEntity.ok().body(patientResponseDTO);
    }

}
