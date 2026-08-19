package com.festivGo.exceptions.custom_exception;

public class VehicleNotFoundException extends RuntimeException {
    public VehicleNotFoundException(String vehicleNo) {
        super("vehicle not found with this vehicle no: " + vehicleNo);
    }
}
