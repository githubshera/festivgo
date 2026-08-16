package com.festivGo.repository;

import com.festivGo.entity.Booking;
import com.festivGo.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.List;

@Repository
public interface BookingRepository extends JpaRepository<Booking, Long> {

 // find booking by event type
    List<Booking> findByEventType(String eventType);

    List<Booking> findBookingsByUser(User user);

    List<Booking> findBookingsByStatus(String status);

    @Query("SELECT b FROM Booking b WHERE b.vehicle.vehicleNo = :vehicleNo " +
            "AND b.status = 'CONFIRM' " +
            "AND ((:startTime BETWEEN b.startTime AND b.endTime) " +
            "OR (:endTime BETWEEN b.startTime AND b.endTime) " +
            "OR (b.startTime BETWEEN :startTime AND :endTime))")
    List<Booking> findConflictingBookings(@Param("vehicleNo") String vehicleNo,
                                          @Param("startTime") LocalDateTime startTime,
                                          @Param("endTime") LocalDateTime endTime);

}
