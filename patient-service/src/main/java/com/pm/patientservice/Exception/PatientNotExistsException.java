package com.pm.patientservice.Exception;

public class PatientNotExistsException extends RuntimeException {
    public PatientNotExistsException(String message) {
        super(message);
    }
}
