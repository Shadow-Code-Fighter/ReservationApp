package com.reservationapp.paylaod;

import lombok.Data;

@Data
public class SearchListOfBusesDto {

//    Bus Details
    private long busId;
    private String busNumber;
    private String busType;
    private String fromLocation;
    private String toLocation;
    private double price;
    private int availableSeats;
    private String fromTime;
    private String toTime;

//    Route Details
    private  Long routeId;
    private String routeFrom;
    private String routeTo;
    private String fromDate;
    private String toDate;
    private Integer distance;

}
