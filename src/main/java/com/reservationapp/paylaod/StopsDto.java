package com.reservationapp.paylaod;

import com.reservationapp.entity.Bus;
import lombok.Data;

@Data
public class StopsDto {
    private int stopId;
    private String location;
    private String arrivalTime;
    private String departureTime;
    private String busNumber;
}
