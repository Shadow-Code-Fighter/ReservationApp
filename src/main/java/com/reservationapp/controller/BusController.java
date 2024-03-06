package com.reservationapp.controller;

import com.reservationapp.paylaod.BusDto;
import com.reservationapp.service.BusService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
}
