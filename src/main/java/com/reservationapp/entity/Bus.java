package com.reservationapp.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.ArrayList;
import java.util.List;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Bus {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "bus_id")
    private long id;

    // Ensure uniqueness for busNumber
    @Column(unique = true)
    private String busNumber;

    private String busType;
    private String fromLocation;
    private String toLocation;

    // Use appropriate data types for date and time
    @DateTimeFormat(pattern = "dd HH yyyy")
    private String fromDate;

    @DateTimeFormat(pattern = "dd HH yyyy")
    private String toDate;

    private String totalDuration;

    @DateTimeFormat(pattern = "HH:mm a")
    private String fromTime;

    @DateTimeFormat(pattern = "HH:mm a")
    private String toTime;

    private double price;
    private int availableSeats;

    // Cascade only specific operations if necessary
    @ManyToOne(cascade = {CascadeType.ALL, CascadeType.MERGE})
    private Route route;

    // Avoid using @JsonIgnore if serialization of subRoutes is required in certain scenarios
    @JsonIgnore
    @OneToMany(mappedBy = "bus", cascade = CascadeType.ALL)
    private List<SubRoutes> subRoutes = new ArrayList<>();

//    @Override
//    public String toString() {
//        return "Bus{" +
//                "busId=" + id +
//                ", busNumber='" + busNumber + '\'' +
//                ", busType='" + busType + '\'' +
//                ", fromLocation='" + fromLocation + '\'' +
//                ", toLocation='" + toLocation + '\'' +
//                ", fromDate='" + fromDate + '\'' +
//                ", toDate='" + toDate + '\'' +
//                ", totalDuration='" + totalDuration + '\'' +
//                ", fromTime='" + fromTime + '\'' +
//                ", toTime='" + toTime + '\'' +
//                ", price=" + price +
//                ", availableSeats=" + availableSeats +
//                // Only include subRoutes size to avoid infinite loop
//                ", subRoutesSize=" + (subRoutes != null ? subRoutes.size() : "null") +
//                '}';
//    }
}

