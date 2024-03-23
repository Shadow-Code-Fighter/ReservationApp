package com.reservationapp.repository;

import com.reservationapp.entity.Bus;
import com.reservationapp.paylaod.BusDto;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface BusRepository extends JpaRepository<Bus,Long> {
    public List<Bus> findByBusType(String busType);
    Optional<Bus> findByBusNumber(String busNumber);
    Bus deleteByBusNumber(String busNumber);
}
