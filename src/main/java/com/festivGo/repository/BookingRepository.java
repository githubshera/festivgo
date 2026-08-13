package com.festivGo.repository;

import com.festivGo.entity.Booking;
import com.festivGo.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface BookingRepository extends JpaRepository<Booking, Long> {

 // find booking by event type
    List<Booking> findByEventType(String eventType);

    List<Booking> findBookingsByUser(User user);

    List<Booking> findBookingsByStatus(String status);
}
