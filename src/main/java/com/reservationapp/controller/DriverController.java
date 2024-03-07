package com.reservationapp.controller;

import com.reservationapp.exception.BusDetailsNotFoundException;
import com.reservationapp.exception.DriverDetailsNotFoundException;
import com.reservationapp.paylaod.DriverDto;
import com.reservationapp.service.DriverService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/driver")
public class DriverController {

    @Autowired
    private DriverService driverService;

    @PostMapping("/add")
    public ResponseEntity<?> addDriver(@RequestBody DriverDto driverDto) throws BusDetailsNotFoundException,DriverDetailsNotFoundException {
        DriverDto driver = driverService.addDriver(driverDto);
        return new ResponseEntity<>(driver, HttpStatus.CREATED);
    }
}
