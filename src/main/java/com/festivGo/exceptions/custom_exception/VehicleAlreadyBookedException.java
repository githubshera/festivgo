package com.festivGo.exceptions.custom_exception;

public class VehicleAlreadyBookedException extends RuntimeException {
    public VehicleAlreadyBookedException(String vehicleNo) {
        super("vehicle " + vehicleNo + " is already booked at time time");
    }
}
