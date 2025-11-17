package com.pm.appointmentservice.Exception;

public class AppointmentStatusExceptionTransition extends RuntimeException {
    public AppointmentStatusExceptionTransition(String message) {
        super(message);
    }
}
