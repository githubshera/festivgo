package com.festivGo.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDate;

@Entity
@Table(name = "bookings")
@Data
public class Booking {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long bookingId;

    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false)
    private User user;

    @ManyToOne
    @JoinColumn(name = "vehicle_id", nullable = false)
    private Vehicle vehicle;

    private String eventType;   // Wedding, Puja, Reception, etc.
    private LocalDate eventDate;
    private String status;      // PENDING, CONFIRMED, CANCELLED
    private double fare;
    private double distance;
}
