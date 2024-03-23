package com.reservationapp.repository;

import com.reservationapp.entity.Route;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface RouteRepository extends JpaRepository<Route, Long> {

    List<Route> findByRouteFromAndRouteToAndFromDate(String routeFrom,String routeTo,String fromDate);
}
