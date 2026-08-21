package com.festivGo.exceptions.custom_exception;

public class BookingNotFoundByIdException extends RuntimeException {
    public BookingNotFoundByIdException(long bookingId) {
        super("No booking found by this booking id: " + bookingId);
    }
}
