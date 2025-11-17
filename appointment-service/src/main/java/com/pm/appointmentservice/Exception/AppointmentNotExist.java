package com.pm.appointmentservice.Exception;

public class AppointmentNotExist extends RuntimeException {
    public AppointmentNotExist(String message) {
        super(message);
    }
}
