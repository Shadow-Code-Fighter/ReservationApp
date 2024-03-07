package com.reservationapp.service;

import com.reservationapp.exception.BusDetailsNotFoundException;
import com.reservationapp.exception.DriverDetailsNotFoundException;
import com.reservationapp.paylaod.DriverDto;

public interface DriverService {

    DriverDto addDriver(DriverDto driverDto) throws BusDetailsNotFoundException, DriverDetailsNotFoundException;
}
