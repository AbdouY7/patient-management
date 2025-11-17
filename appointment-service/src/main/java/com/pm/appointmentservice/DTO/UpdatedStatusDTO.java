package com.pm.appointmentservice.DTO;

import com.pm.appointmentservice.Entity.Status;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UpdatedStatusDTO {
    private Status status;
}
