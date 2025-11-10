package com.pm.doctorservice.Exception;

public class ExistingDoctorException extends RuntimeException {
    public ExistingDoctorException(String message) {
        super(message);
    }
}
