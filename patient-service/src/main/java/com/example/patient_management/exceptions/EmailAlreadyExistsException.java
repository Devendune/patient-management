package com.example.patient_management.exceptions;

public class EmailAlreadyExistsException extends RuntimeException
{
    public EmailAlreadyExistsException(String message) {
        super(message);
    }
}
