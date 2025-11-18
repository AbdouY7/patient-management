package com.pm.medicalservice.Exception;

public class NotExistsException extends RuntimeException {
    public NotExistsException(String message) {
        super(message);
    }
}
