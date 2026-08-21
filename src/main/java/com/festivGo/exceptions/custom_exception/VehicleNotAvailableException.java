package com.festivGo.exceptions.custom_exception;

public class VehicleNotAvailableException extends RuntimeException {
    public VehicleNotAvailableException(String vehicleNo) {
        super("Vehicle is not available: " + vehicleNo);
    }
}
