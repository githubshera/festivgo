package com.festivGo.exceptions.custom_exception;

public class VehicleAlreadyExistsException extends RuntimeException {
    public VehicleAlreadyExistsException(String vehicleNo) {
        super("vehicle already present with this vehicle no: " + vehicleNo);
    }
}
