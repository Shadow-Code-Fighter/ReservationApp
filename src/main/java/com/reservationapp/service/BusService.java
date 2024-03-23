package com.reservationapp.service;

import com.reservationapp.entity.Bus;
import com.reservationapp.exception.BusDetailsNotFoundException;
import com.reservationapp.paylaod.BusDto;
import com.reservationapp.paylaod.SearchListOfBusesDto;
import com.reservationapp.paylaod.StopDto;

import java.util.List;

public interface BusService {
    BusDto addBus(BusDto busDto) throws BusDetailsNotFoundException;

    BusDto getBusById(long busId);

    List<Bus> viewAllBuses();

    List<Bus> getBusesByBusType(String busType);

    void deleteBusByBusId(long busId);

    void deleteRouteByRouteId(long routeId);

    List<SearchListOfBusesDto> getAllBuses(String routeFrom, String routeTo, String fromDate);
}
