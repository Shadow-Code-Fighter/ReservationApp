package com.reservationapp.repository;

import com.reservationapp.entity.BusStops;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface BusStopsRepository extends JpaRepository<BusStops, Long> {
    @Query("SELECT bs FROM BusStops bs JOIN FETCH bs.bus")
    List<BusStops> findAllWithBusId();
    List<BusStops> findByLocation(String location);

}
