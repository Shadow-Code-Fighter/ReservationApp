package com.reservationapp.controller;

import com.reservationapp.entity.Bus;
import com.reservationapp.paylaod.BusDto;
import com.reservationapp.service.BusService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/bus")
public class BusController {

    @Autowired
    private BusService busService;

    @PostMapping("/add")
    public ResponseEntity<?> addBus(@RequestBody BusDto busDto){
        BusDto dto = busService.addBus(busDto);
        return new ResponseEntity<>("Data Saved!!!", HttpStatus.CREATED);
    }

    @GetMapping("/{bus_id}")
    public ResponseEntity<Bus> getBusById(@PathVariable long bus_id){
        Bus bus = busService.getBusById(bus_id);
        return new ResponseEntity<>(bus,HttpStatus.ACCEPTED);
    }

    @GetMapping("/all/bus")
    public ResponseEntity<List<Bus>> viewAllBuses(){
        List<Bus> bus = busService.viewAllBuses();
        return new ResponseEntity<>(bus,HttpStatus.ACCEPTED);
    }

    @GetMapping("/type/{busType}")
    public ResponseEntity<List<Bus>> getBusesByBusType(@PathVariable String busType){
        List<Bus> busList = busService.getBusesByBusType(busType);
        return new ResponseEntity<>(busList,HttpStatus.ACCEPTED);
    }
}
