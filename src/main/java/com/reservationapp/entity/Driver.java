package com.reservationapp.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Driver {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String name;
    private String licenseNumber;
    private String adharNumber;
    private String address;
    private String contactNumber;
    private String alternateContactNumber;
    private String email;

    @OneToOne(cascade = CascadeType.ALL)
    private Bus bus;
}
