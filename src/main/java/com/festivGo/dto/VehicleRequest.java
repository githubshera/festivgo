package com.festivGo.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Positive;
import lombok.Data;

@Data
public class VehicleRequest {

    @NotBlank
    private String vehicleType;

    @Positive
    private int capacity;

    @Positive
    private double farePerKm;

    @NotBlank
    private String vehicleNo;

    private boolean availability = true;
}
