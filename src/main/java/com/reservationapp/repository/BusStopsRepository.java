package com.reservationapp.repository;

import com.reservationapp.entity.BusStops;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BusStopsRepository extends JpaRepository<BusStops, Long> {
}
