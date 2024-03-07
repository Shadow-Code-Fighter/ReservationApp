package com.reservationapp.service;

import com.reservationapp.entity.Bus;
import com.reservationapp.entity.Route;
import com.reservationapp.entity.Stops;
import com.reservationapp.exception.BusDetailsNotFoundException;
import com.reservationapp.exception.RouteDetailsNotFoundException;
import com.reservationapp.exception.SubRouteDetailsNotFoundException;
import com.reservationapp.paylaod.BusDto;
import com.reservationapp.repository.BusRepository;
import com.reservationapp.repository.RouteRepository;
import com.reservationapp.repository.StopsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BusServiceImpl implements BusService{

    @Autowired
    private BusRepository busRepository;

    @Autowired
    private RouteRepository routeRepository;
    @Autowired
    private StopsRepository stopsRepository;
//    @Autowired
//    private DriverRepository driverRepository;

    @Autowired
    private ModelMapper modelMapper;
//    @Override
//    public BusDto addBus(BusDto busDto) {
//        Bus mapToEntity = modelMapper.map(busDto, Bus.class);
////        driverRepository.save(busDto.getDriver());
//        routeRepository.save(busDto.getRoute());
//        subRoutesRepository.save(busDto.getSubRoutes());
//        Bus savedBus = busRepository.save(mapToEntity);
//        BusDto mapToDto = modelMapper.map(savedBus, BusDto.class);
//        return mapToDto;
//    }
    @Override
    public BusDto addBus(BusDto busDto) {
        // Map BusDto to Bus entity
        Bus bus = modelMapper.map(busDto, Bus.class);

        // Save associated Route entity
        Route route = bus.getRoute();
        routeRepository.save(route);

        // Save associated SubRoutes entities
        List<Stops> stop = bus.getStop();
        if (stop != null) {
            for (Stops stopBus : stop) {
                stopBus.setBus(bus);
            }
        }

        // Save Bus entity
        Bus savedBus = busRepository.save(bus);

        // Map saved Bus entity to BusDto
        BusDto savedBusDto = modelMapper.map(savedBus, BusDto.class);

        return savedBusDto;
    }

    @Override
    public Bus getBusById(long busId) {
        Bus bus = busRepository.findById(busId).get();
        return bus;
    }

    @Override
    public List<Bus> viewAllBuses() {
        List<Bus> allBus = busRepository.findAll();
        return allBus;
    }

    @Override
    public List<Bus> getBusesByBusType(String busType) {
        List<Bus> byBusType = busRepository.findByBusType(busType);
        return byBusType;
    }
}
