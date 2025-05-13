package com.example.patient_management.Model;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;

import javax.annotation.processing.Generated;
import java.util.UUID;

@Entity
public class Patient
{
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private UUID id;

    @NotNull
    private String name;

    @NotNull
    @Email
    @Column(unique = true)
    private String email;




}

