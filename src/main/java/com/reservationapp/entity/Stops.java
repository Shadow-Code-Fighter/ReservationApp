package com.reservationapp.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalTime;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "bus_stops")
public class Stops {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "stop_id")
    private int stopId;

    @NotNull(message = "location point cannot be null !")
    @NotBlank(message = "location point cannot be blank !")
    @NotEmpty(message = "location point cannot be empty !")
    private String location;

    @NotNull(message = "arrivalTime point cannot be null !")
    @NotBlank(message = "arrivalTime point cannot be blank !")
    @NotEmpty(message = "arrivalTime point cannot be empty !")
    @Column(name = "arrival_time")
    private String arrivalTime;

    @NotNull(message = "departureTime point cannot be null !")
    @NotBlank(message = "departureTime point cannot be blank !")
    @NotEmpty(message = "departureTime point cannot be empty !")
    @Column(name = "departure_time")
    private String departureTime;

    @ManyToOne(cascade = CascadeType.ALL)
    private Bus bus;
}
