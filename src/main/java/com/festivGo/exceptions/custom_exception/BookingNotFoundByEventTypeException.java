package com.festivGo.exceptions.custom_exception;

public class BookingNotFoundByEventTypeException extends RuntimeException {
    public BookingNotFoundByEventTypeException (String eventType) {
        super("No booking found by this event type: " + eventType);
    }
}
