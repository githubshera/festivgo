package com.festivGo.dto;

import lombok.Data;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Data
public class BookingRequest {
    private String vehicleNo;
    private String phone;
    private String eventType;
    //private LocalDateTime localDateTime;
    private double distance;
}
