package com.reservationapp.paylaod;

import lombok.Data;

@Data
public class BusStopsDto {
    private int stopId;
    private String location;
    private String arrivalTime;
    private String departureTime;
    private String busNumber;
}
