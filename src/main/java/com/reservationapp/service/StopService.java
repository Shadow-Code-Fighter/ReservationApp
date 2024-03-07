package com.reservationapp.service;


import com.reservationapp.exception.BusDetailsNotFoundException;
import com.reservationapp.paylaod.StopsDto;

public interface StopService {

    public StopsDto addStops(StopsDto stopsDto) throws BusDetailsNotFoundException;
}
