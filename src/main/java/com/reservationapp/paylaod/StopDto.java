package com.reservationapp.paylaod;

import com.reservationapp.entity.BusStops;
import com.reservationapp.entity.Route;
import lombok.Data;

import java.util.List;

@Data
public class StopDto {
    private long busId;
    private String busNumber;
    private String busType;
    private String fromLocation;
    private String toLocation;
    private String fromDate;
    private String toDate;
    private String totalDuration;
    private String fromTime;
    private String toTime;
    private double price;
    private int availableSeats;
    private List<BusStops> stops;
}
