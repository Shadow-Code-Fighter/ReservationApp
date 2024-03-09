package com.reservationapp.service;


import com.reservationapp.exception.BusDetailsNotFoundException;
import com.reservationapp.paylaod.StopsDto;

public interface StopService {

    public StopsDto addBusStops(StopsDto stopsDto) throws BusDetailsNotFoundException;
}
