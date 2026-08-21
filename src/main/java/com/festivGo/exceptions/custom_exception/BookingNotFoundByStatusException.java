package com.festivGo.exceptions.custom_exception;

public class BookingNotFoundByStatusException extends RuntimeException {
    public BookingNotFoundByStatusException(String status) {
        super("No booking found by this staus: " + status);
    }
}
