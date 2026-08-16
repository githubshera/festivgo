package com.festivGo.dto;

import com.festivGo.constants.Role;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import lombok.Data;

@Data
public class UserRequest {
    @NotBlank
    private String name;

    @Pattern(regexp = "^[0-9]{10}$")
    private String phone;

    private Role role; // ADMIN or CUSTOMER
}
