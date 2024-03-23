package com.reservationapp.service;


import com.reservationapp.entity.BusStops;
import com.reservationapp.exception.BusDetailsNotFoundException;
import com.reservationapp.exception.BusStopsNotFoundException;
import com.reservationapp.paylaod.BusStopsDto;

import java.util.List;

public interface BusStopService {

    public BusStopsDto addBusStops(BusStopsDto busStopsDto) throws BusDetailsNotFoundException;

    List<BusStops> viewBusStops();

    List<BusStops> viewByLocationName(String location);
}
