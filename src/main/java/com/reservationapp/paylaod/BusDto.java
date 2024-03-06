package com.reservationapp.paylaod;

import com.reservationapp.entity.Driver;
import com.reservationapp.entity.Route;
import com.reservationapp.entity.SubRoutes;
import lombok.Data;

import java.util.List;

@Data
public class BusDto {

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
//    private Driver driver;
    private Route route;
    private List<SubRoutes> subRoutes;
}
