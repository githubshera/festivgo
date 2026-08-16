package com.festivGo.dto;

import lombok.Data;
import java.time.LocalDateTime;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Positive;


@Data
public class BookingRequest {

    @NotBlank(message = "Vehicle number is required")
    private String vehicleNo;

    @Pattern(regexp = "^[0-9]{10}$, message = Phone must be 10 digits")
    private String phone;

    @NotBlank(message = "Event type is required")
    private String eventType;

    @NotNull(message = "Start time is required")
    private LocalDateTime startDate;

    @NotNull(message = "End time is required")
    private LocalDateTime endDate;
    @Positive(message = "Distance must be greater than 0")
    private double distance;
}
