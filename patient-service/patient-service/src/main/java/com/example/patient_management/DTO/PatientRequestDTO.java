package com.example.patient_management.DTO;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public class PatientRequestDTO
{
    @NotBlank
    @Size(max = 100 ,message = "Name cannot exceed 100 characters")
    private String name;

    @NotBlank(message="Email is required")
    @Email(message = "Email is required")
    private String email;


    @NotBlank(message="address is required")
    private String address;

    @NotBlank(message="Date of Birth is required")
    private String dateOfBirth;

    @NotBlank(message="registeredDate is required")
    private String registeredDate;

}
