package com.reservationapp.service;

import com.reservationapp.entity.Bus;
import com.reservationapp.exception.BusDetailsNotFoundException;
import com.reservationapp.paylaod.BusDto;

import java.util.List;

public interface BusService {
    BusDto addBus(BusDto busDto) throws BusDetailsNotFoundException;

    Bus getBusById(long busId);

    List<Bus> viewAllBuses();

    List<Bus> getBusesByBusType(String busType);
}
