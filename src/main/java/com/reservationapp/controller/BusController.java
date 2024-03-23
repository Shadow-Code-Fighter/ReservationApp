package com.reservationapp.controller;

import com.reservationapp.entity.Bus;
import com.reservationapp.exception.BusDetailsNotFoundException;
import com.reservationapp.paylaod.BusDto;
import com.reservationapp.paylaod.SearchListOfBusesDto;
import com.reservationapp.paylaod.StopDto;
import com.reservationapp.service.BusService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/yatra")
public class BusController {

    @Autowired
    private BusService busService;


    //    http://localhost:8080/yatra/bus/add
    @PostMapping("/bus/add")
    public ResponseEntity<?> addBus(@Valid @RequestBody BusDto busDto) throws BusDetailsNotFoundException {
        BusDto dto = busService.addBus(busDto);
        return new ResponseEntity<>(dto, HttpStatus.CREATED);
    }

//    http://localhost:8080/yatra/bus/{bus_id}
    @GetMapping("/bus/{bus_id}")
    public ResponseEntity<BusDto> getBusById(@PathVariable("busId") long bus_id){
        BusDto busDto = busService.getBusById(bus_id);
        return new ResponseEntity<>(busDto,HttpStatus.ACCEPTED);
    }

//  http://localhost:8080/yatra/bus/all/bus
    @GetMapping("/bus/all/bus")
    public ResponseEntity<List<Bus>> viewAllBuses(){
        List<Bus> bus = busService.viewAllBuses();
        return new ResponseEntity<>(bus,HttpStatus.ACCEPTED);
    }

//    http://localhost:8080/yatra/bus/type/{busType}
    @GetMapping("/bus/type/{busType}")
    public ResponseEntity<List<Bus>> getBusesByBusType(@PathVariable("busType") String busType){
        List<Bus> busList = busService.getBusesByBusType(busType);
        return new ResponseEntity<>(busList,HttpStatus.ACCEPTED);
    }

//    http://localhost:8080/yatra/bus/{busId}
    @DeleteMapping("/bus/{busId}")
    public ResponseEntity<?> deleteBusByBusId(@PathVariable("routeId")  long busId){
        busService.deleteBusByBusId(busId);
        return new ResponseEntity<>("Bus Deleted",HttpStatus.OK);
    }


//    http://localhost:8080/yatra/route/{routeId}
    @DeleteMapping("/route/{routeId}")
    public ResponseEntity<?> deleteRouteByRouteId(long routeId){
        busService.deleteRouteByRouteId(routeId);
        return new ResponseEntity<>("Route Deleted", HttpStatus.OK);
    }

//    http://localhost:8080/yatra/allbus?routeFrom=&routeTo=&fromDate=
    @GetMapping("/bus/allbus")
    public List<SearchListOfBusesDto> getAllBuses(@RequestParam String routeFrom,
                                 @RequestParam String routeTo,
                                 @RequestParam String fromDate){
        List<SearchListOfBusesDto> busList = busService.getAllBuses(routeFrom,routeTo,fromDate);
        return busList;
    }
}
