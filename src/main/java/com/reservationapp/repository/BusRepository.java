package com.reservationapp.repository;

import com.reservationapp.entity.Bus;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface BusRepository extends JpaRepository<Bus,Long> {
    public List<Bus> findByBusType(String busType);
}
