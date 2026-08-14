package com.festivGo.controller;

import com.festivGo.dto.BookingRequest;
import com.festivGo.entity.Booking;
import com.festivGo.service.BookingService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@Slf4j
@RestController
@RequestMapping("/booking/v1")
public class BookingController {

    @Autowired
    private BookingService bookingService;

    @PostMapping("/create-booking")
    public ResponseEntity<Booking> createBooking(@RequestBody BookingRequest bookingRequest) {
        Booking booking = bookingService.createBooking(
                bookingRequest.getVehicleNo(),
                bookingRequest.getPhone(),
                bookingRequest.getEventType(),
                bookingRequest.getDistance()
        );
       return new ResponseEntity<>(booking, HttpStatus.CREATED);
    }

    @GetMapping("/phone-no/{phone}")
    public ResponseEntity<List<Booking>> findBookingByPhone(@PathVariable String phone) {
        log.info(" inside controller booking info: {}" , phone);
         List<Booking> booking = bookingService.getBookingByPhone(phone);
        log.info(" inside controller booking info: {}" , booking);
         return new ResponseEntity<>(booking, HttpStatus.OK);
    }

    @GetMapping("/event-type/{eventType}")
    public ResponseEntity<List<Booking>> findBookingByEventType(@PathVariable String eventType) {
        List<Booking> booking = bookingService.getBookingByEventType(eventType);
        return new ResponseEntity<>(booking, HttpStatus.OK);
    }

    @GetMapping("/status/{status}")
    public ResponseEntity<List<Booking>> findBookingByStatus(@PathVariable String status) {
        List<Booking> booking = bookingService.getBookingByStatus(status);
        return new ResponseEntity<>(booking, HttpStatus.OK);
    }

    @PutMapping("/{bookingId}")
    public ResponseEntity<Booking> updateBookingById(@PathVariable long bookingId, @RequestBody BookingRequest bookingRequest) {
          Booking booking = bookingService.updateBooking(
                   bookingId,
                   bookingRequest.getEventType(),
                   bookingRequest.getDistance(),
                   bookingRequest.getVehicleNo());
          return new ResponseEntity<>(booking, HttpStatus.OK);
    }

    @PutMapping("/{bookingId}/cancel")
    public ResponseEntity<Booking> cancelByBookingId(@PathVariable long bookingId) {
        return new ResponseEntity<>(bookingService.cancelBookingById(bookingId), HttpStatus.OK);
    }

    @DeleteMapping("/{bookingId}")
    public ResponseEntity<Void> deleteByBookingId(@PathVariable long bookingId) {
        bookingService.deleteByBookingId(bookingId);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
