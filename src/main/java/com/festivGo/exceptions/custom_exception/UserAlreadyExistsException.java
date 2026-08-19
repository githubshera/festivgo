package com.festivGo.exceptions.custom_exception;

public class UserAlreadyExistsException extends RuntimeException {
    public UserAlreadyExistsException(String phone) {
        super("user already present with this phone no: " + phone);
    }
}
