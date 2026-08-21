package com.festivGo.exceptions.custom_exception;

public class BookingNotFoundByUserException extends RuntimeException  {
    public BookingNotFoundByUserException(String phone) {
        super("No booking found by this user: " + phone);
    }
}
