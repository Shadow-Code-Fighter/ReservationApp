package com.reservationapp.service;

import com.reservationapp.entity.Passenger;
import com.reservationapp.paylaod.ReservationDto;

public interface ReservationService {
    void bookTicket(long busId, long routeId, Passenger passenger);
}
