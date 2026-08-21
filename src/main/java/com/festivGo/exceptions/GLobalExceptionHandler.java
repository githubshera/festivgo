package com.festivGo.exceptions;

import com.festivGo.exceptions.custom_exception.*;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;

@RestControllerAdvice
public class GLobalExceptionHandler {

    @ExceptionHandler(UserAlreadyExistsException.class)
    public ResponseEntity<Map<String, Object>>  handleUserAlreadyExistsException(UserAlreadyExistsException e) {
        return buildResponse(HttpStatus.CONFLICT, e.getMessage());
    }

    @ExceptionHandler(UserNotFoundException.class)
    public ResponseEntity<Map<String, Object>>  handleUserNotFoundException(UserNotFoundException e) {
        return buildResponse(HttpStatus.NOT_FOUND, e.getMessage());
    }

    @ExceptionHandler(VehicleAlreadyExistsException.class)
    public ResponseEntity<Map<String, Object>>  handleVehicleAlreadyExistsException(VehicleAlreadyExistsException e) {
        return buildResponse(HttpStatus.CONFLICT, e.getMessage());
    }

    @ExceptionHandler(VehicleNotFoundException.class)
    public ResponseEntity<Map<String, Object>>  handleVehicleNotFoundException(VehicleNotFoundException e) {
        return buildResponse(HttpStatus.NOT_FOUND, e.getMessage());
    }


    @ExceptionHandler(VehicleNotAvailableException.class)
    public ResponseEntity<Map<String, Object>>  handleVehicleNotAvailableException(VehicleNotAvailableException e) {
        return buildResponse(HttpStatus.NOT_FOUND, e.getMessage());
    }

    @ExceptionHandler(VehicleAlreadyBookedException.class)
    public ResponseEntity<Map<String, Object>>  handleVehicleAlreadyBookedException(VehicleAlreadyBookedException e) {
        return buildResponse(HttpStatus.NOT_FOUND, e.getMessage());
    }

    @ExceptionHandler(BookingNotFoundByUserException.class)
    public ResponseEntity<Map<String, Object>>  handleBookingNotFoundByUserException(BookingNotFoundByUserException e) {
        return buildResponse(HttpStatus.NOT_FOUND, e.getMessage());
    }

    @ExceptionHandler(BookingNotFoundByStatusException.class)
    public ResponseEntity<Map<String, Object>>  handleBookingNotFoundByStatusException(BookingNotFoundByStatusException e) {
        return buildResponse(HttpStatus.NOT_FOUND, e.getMessage());
    }

    @ExceptionHandler(BookingNotFoundByIdException.class)
    public ResponseEntity<Map<String, Object>>  handleBookingNotFoundByIdException(BookingNotFoundByIdException e) {
        return buildResponse(HttpStatus.NOT_FOUND, e.getMessage());
    }

    @ExceptionHandler(BookingNotFoundByEventTypeException.class)
    public ResponseEntity<Map<String, Object>>  handleBookingNotFoundByEventTypeException(BookingNotFoundByEventTypeException e) {
        return buildResponse(HttpStatus.NOT_FOUND, e.getMessage());
    }

    private ResponseEntity<Map<String, Object>> buildResponse(HttpStatus status, String message) {
        Map<String, Object> body = new HashMap<>();
        body.put("status", status.value());
        body.put("error", status.getReasonPhrase());
        body.put("message", message);
        body.put("timestamp", LocalDateTime.now());
        return new ResponseEntity<>(body, status);
    }
}
