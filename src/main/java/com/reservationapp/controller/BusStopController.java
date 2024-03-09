package com.reservationapp.controller;

import com.reservationapp.exception.BusDetailsNotFoundException;
import com.reservationapp.paylaod.StopsDto;
import com.reservationapp.service.StopService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/stops")
public class BusStopController {
    @Autowired
    private StopService stopService;

    @PostMapping("/add")
    public ResponseEntity<StopsDto> addBusStops(@RequestBody StopsDto stopsDto) throws BusDetailsNotFoundException {
        StopsDto dto = stopService.addBusStops(stopsDto);
        return new ResponseEntity<>(dto, HttpStatus.CREATED);
    }
}
