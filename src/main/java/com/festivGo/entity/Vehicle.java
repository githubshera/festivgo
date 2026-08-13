package com.festivGo.entity;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "vehicles")
@Data
public class Vehicle {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long vehicleId;
    private String vehicleType;
    private int capacity;
    private double farePerKm;
    private String vehicleNo;
    private boolean availability;
}
