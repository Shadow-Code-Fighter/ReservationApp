package com.reservationapp.controller;

import com.reservationapp.entity.BusStops;
import com.reservationapp.exception.BusDetailsNotFoundException;
import com.reservationapp.exception.BusStopsNotFoundException;
import com.reservationapp.paylaod.BusStopsDto;
import com.reservationapp.service.BusStopService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/yatra")
public class BusStopController {
    @Autowired
    private BusStopService busStopService;

//    http://localhost:8080/yatra/bus_stops/add
    @PostMapping("/bus_stops/add")
    public ResponseEntity<BusStopsDto> addBusStops(@RequestBody BusStopsDto busStopsDto) throws BusDetailsNotFoundException {
        BusStopsDto dto = busStopService.addBusStops(busStopsDto);
        return new ResponseEntity<>(dto, HttpStatus.CREATED);
    }

//    http://localhost:8080/yatra/bus_stops/all
    @GetMapping("/bus_stops/all")
    public ResponseEntity<List<BusStops>> viewBusStops(){
        List<BusStops> listBusStopsDto = busStopService.viewBusStops();
        return new ResponseEntity<>(listBusStopsDto,HttpStatus.ACCEPTED);
    }

//    http://localhost:8080/yatra/bus_stops/location?location=Location%20c
    @GetMapping("/bus_stops")
    public ResponseEntity<List<BusStops>> viewByLocationName(@RequestParam String location) {
       List<BusStops> stops = busStopService.viewByLocationName(location);
       return new ResponseEntity<>(stops,HttpStatus.ACCEPTED);
    }
}
