package com.reservationapp.service;

import com.reservationapp.entity.Bus;
import com.reservationapp.paylaod.BusDto;

import java.util.List;

public interface BusService {
    BusDto addBus(BusDto busDto);

    Bus getBusById(long busId);

    List<Bus> viewAllBuses();

    List<Bus> getBusesByBusType(String busType);
}
