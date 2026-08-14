package com.festivGo.service;

import com.festivGo.constants.Constant;
import com.festivGo.entity.Booking;
import com.festivGo.entity.User;
import com.festivGo.entity.Vehicle;
import com.festivGo.repository.BookingRepository;
import com.festivGo.repository.UserRepository;
import com.festivGo.repository.VehicleRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Slf4j
@Service
public class BookingService {

    @Autowired
    private BookingRepository bookingRepository;

    @Autowired
    VehicleRepository vehicleRepository;

    @Autowired
    UserRepository userRepository;

    public Booking createBooking(String vehicleNo, String phone, String eventType, double distance) {
        Vehicle vehicle = vehicleRepository.findByVehicleNo(vehicleNo);
        User userExist = userRepository.findByPhone(phone);
        if(vehicle == null || !vehicle.isAvailability()) {
            throw new IllegalArgumentException("vehicle is not available");
        }
       if(userExist== null) {
           throw new IllegalArgumentException("user no exist");
       }

       double fare = distance * vehicle.getFarePerKm();
       Booking booking = new Booking();
       booking.setUser(userExist);
       booking.setEventDate(LocalDate.now());
       booking.setStatus(String.valueOf(Constant.CONFIRM));
       booking.setEventType(eventType);
       booking.setFare(fare);
       booking.setDistance(distance);
       booking.setVehicle(vehicle);
       vehicle.setAvailability(false);
        System.out.println("before vehicle saving" + vehicle);
       vehicleRepository.save(vehicle);
        return  bookingRepository.save(booking);
    }

    public List<Booking> getBookingByPhone(String phone) {
       User existUser =  userRepository.findByPhone(phone);
        log.info(" inside service booking info: {}" , existUser);
       if(existUser == null) {
           throw new IllegalArgumentException("no booking found by this user" + phone);
       }
       return bookingRepository.findBookingsByUser(existUser);
    }

    public List<Booking> getBookingByEventType(String eventType) {
           List<Booking> booking =  bookingRepository.findByEventType(eventType);
           if(booking == null) {
               throw new IllegalArgumentException("no booking found by this event type: " + eventType);
           }
           return  booking;
    }

    public List<Booking> getBookingByStatus(String status) {
        List<Booking> booking =  bookingRepository.findBookingsByStatus(status);
        if(booking == null) {
            throw new IllegalArgumentException("no booking found by this status: " + status);
        }
        return  booking;
    }

    public Booking updateBooking(long bookingId, String eventType, double distance, String vehicleNo) {
        Booking booking = bookingRepository.findById(bookingId).orElseThrow(() -> new IllegalArgumentException("no booking found " + bookingId));
        // check vehicle changed or not
        if (vehicleNo != null && !vehicleNo.equals(booking.getVehicle().getVehicleNo())) {
            Vehicle newVehicle = vehicleRepository.findByVehicleNo(vehicleNo);
            if (newVehicle == null || !newVehicle.isAvailability()) {
                throw new IllegalArgumentException("vehicle not available " + vehicleNo);
            }
            // free old vehicle
            booking.getVehicle().setAvailability(true);
            vehicleRepository.save(booking.getVehicle());

            // assign new vehicle
            booking.setVehicle(newVehicle);
            newVehicle.setAvailability(false);
            vehicleRepository.save(newVehicle);
        }

        if (eventType != null) {
            booking.setEventType(eventType);
        }
        if (distance > 0) {
            booking.setDistance(distance);
            booking.setFare(distance * booking.getVehicle().getFarePerKm());
        }
        return bookingRepository.save(booking);
    }

    public Booking cancelBookingById(Long id) {
        Booking booking = bookingRepository.findById(id).orElseThrow(()->new IllegalArgumentException("no booking found " + id));
        booking.setStatus(String.valueOf(Constant.CANCELLED));
        booking.getVehicle().setAvailability(true);
        vehicleRepository.save(booking.getVehicle());
       return bookingRepository.save(booking);
    }

    public void deleteByBookingId(Long id) {
        if(!bookingRepository.existsById(id)) {
            throw new IllegalArgumentException("not found by id " + id);
        }
        bookingRepository.deleteById(id);
    }
}
