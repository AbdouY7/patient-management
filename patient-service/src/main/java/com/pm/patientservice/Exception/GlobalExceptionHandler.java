package com.pm.patientservice.Exception;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.util.HashMap;
import java.util.Map;

@Slf4j
@ControllerAdvice
public class GlobalExceptionHandler {
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<Map<String,String>> handleMethodArgumentNotValidException(MethodArgumentNotValidException ex){
        Map<String,String> errors = new HashMap<>();
        ex.getBindingResult().getAllErrors().forEach((error)->{
            errors.put(error.getObjectName(),error.getDefaultMessage());
        });
                return ResponseEntity.badRequest().body(errors);
    }

    @ExceptionHandler(EmailAlreadyExistsException.class)
    public ResponseEntity<Map<String,String>> handleEmailAlreadyExistsException(EmailAlreadyExistsException ex){

        log.warn("Email Already Exists {}", ex.getMessage());
        Map<String,String> errors = new HashMap<>();
        errors.put("message","Email already exists");
        return ResponseEntity.badRequest().body(errors);
    }

    @ExceptionHandler(PatientNotExistsException.class)
    public ResponseEntity<Map<String,String>> handlePatientNotExistsException(PatientNotExistsException ex){

        log.warn("Patient Not Exists {}", ex.getMessage());

        Map<String,String> errors = new HashMap<>();
        errors.put("message","Patient Not Exists");
        return ResponseEntity.badRequest().body(errors);
    }
}
