package com.festivGo.exceptions.custom_exception;

public class UserNotFoundException extends RuntimeException {
    public UserNotFoundException(String phone) {
        super("user not found with this phone no: " + phone);
    }
}
