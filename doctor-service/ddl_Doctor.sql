CREATE TABLE doctor
(
    doctor_id    UUID NOT NULL,
    doctor_name  VARCHAR(255),
    doctor_email VARCHAR(255),
    doctor_phone VARCHAR(255),
    speciality   VARCHAR(255),
    CONSTRAINT pk_doctor PRIMARY KEY (doctor_id)
);