package com.festivGo.entity;


import com.festivGo.constants.Role;
import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "users")
@Data
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long userid;

    private String name;
    private String phone;

    @Enumerated(EnumType.STRING)
    private Role role; // ADMIN or CUSTOMER
}
