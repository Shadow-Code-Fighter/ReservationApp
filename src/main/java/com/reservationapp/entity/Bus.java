package com.reservationapp.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.*;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.ArrayList;
import java.util.List;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
//@ToString
public class Bus {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "bus_id")
    private long id;

    // Ensure uniqueness for busNumber
    @Column(unique = true)
    private String busNumber;

    @NotBlank(message = "Bus Type can't be null/blank, Please provide a valid bus type")
    @Column(name = "bus_type")
    private String busType;

    @NotBlank(message = "Choose a valid starting point.")
    @Column(name = "from_location")
    private String fromLocation;

    @NotBlank(message = "Choose a valid destination.")
    @Column(name = "to_location")
    private String toLocation;

    @NotNull(message = "Bus Journey Date can't be null, Please provide correct date")
    @DateTimeFormat(pattern = "dd-HH-yyyy")  // Use appropriate data types for date
    private String fromDate;

    @NotNull(message = "Bus Journey Date can't be null, Please provide correct date")
    @DateTimeFormat(pattern = "dd-HH-yyyy")
    private String toDate;

    @Column(name = "total_duration")
    private String totalDuration;

    @DateTimeFormat(pattern = "HH:mm a")
    private String fromTime;

    @DateTimeFormat(pattern = "HH:mm a")
    @Column(name = "to_time")
    private String toTime;

    @NotNull(message = "fare can't be null")
    private double price;

    @Column(name = "available_seats")
    private int availableSeats;

    // Cascade only specific operations if necessary
    @ManyToOne(cascade = {CascadeType.ALL, CascadeType.MERGE})
    @JoinColumn(name = "route_id")
    private Route route;

    // Avoid using @JsonIgnore if serialization of subRoutes is required in certain scenarios
    @JsonIgnore
    @OneToMany(mappedBy = "bus", cascade = CascadeType.ALL)
    private List<BusStops> stop = new ArrayList<>();

    @JsonIgnore
    @OneToOne(mappedBy = "bus",cascade = CascadeType.ALL)
    private Driver driver;

    @Override
    public String toString() {
        return "Bus{" +
                "busId=" + id +
                ", busNumber='" + busNumber + '\'' +
                ", busType='" + busType + '\'' +
                ", fromLocation='" + fromLocation + '\'' +
                ", toLocation='" + toLocation + '\'' +
                ", fromDate='" + fromDate + '\'' +
                ", toDate='" + toDate + '\'' +
                ", totalDuration='" + totalDuration + '\'' +
                ", fromTime='" + fromTime + '\'' +
                ", toTime='" + toTime + '\'' +
                ", price=" + price +
                ", availableSeats=" + availableSeats+
                // Only include subRoutes size to avoid infinite loop
//                ", subRoutesSize=" + (stop != null ? stop.size() : "null") +
                '}';
    }
}

