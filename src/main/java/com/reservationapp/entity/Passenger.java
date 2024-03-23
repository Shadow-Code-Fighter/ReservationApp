package com.reservationapp.entity;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
@Table(name = "passengers")
public class Passenger {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String firstName;
    private String lastName;
    private String email;
    private Long mobile;
    @Column(name = "bus_id",unique = true)
    private long busId;
    @Column(name = "route_id",unique = true)
    private long routeId;
}
