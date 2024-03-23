package com.reservationapp.controller;

import com.reservationapp.entity.Passenger;
import com.reservationapp.repository.PassengerRepository;
import com.reservationapp.service.ReservationService;
import com.reservationapp.util.ExcelGeneratorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.List;

@RestController
@RequestMapping("/yatra")
public class ReservationController {

    @Autowired
    private ReservationService reservationService;
    @Autowired
    private PassengerRepository passengerRepository;

    @Autowired
    private ExcelGeneratorService excelGeneratorService;


//    http://localhost:8080/yatra?busId=4&routeId=4

    @PostMapping
    public ResponseEntity<String> bookTicket(@RequestParam long busId,
                                     @RequestParam long routeId,
                                     @RequestBody Passenger passenger){
        reservationService.bookTicket(busId,routeId,passenger);
        return new ResponseEntity<>("Done", HttpStatus.OK);
    }

    @GetMapping("/passengers/excel")
    public ResponseEntity<byte[]> generatePassengersExcel() {
        try {
            List<Passenger> passengers = passengerRepository.findAll();
            byte[] excelBytes = excelGeneratorService.generateExcel(passengers);

            HttpHeaders headers = new HttpHeaders();
            headers.setContentType(MediaType.APPLICATION_OCTET_STREAM);
            headers.setContentDispositionFormData("attachment", "passengers.xlsx");
//            headers.setContentLength(excelBytes.length);

            return new ResponseEntity<>(excelBytes, headers, HttpStatus.OK);
        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
