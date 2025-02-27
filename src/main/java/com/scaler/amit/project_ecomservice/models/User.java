package com.scaler.amit.project_ecomservice.models;

import jakarta.persistence.Entity;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@Entity
public class User {
    private Long id;
    private String name;
    private String email;
    private String address;
    private List<String> roles;
}
