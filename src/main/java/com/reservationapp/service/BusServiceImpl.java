package com.reservationapp.service;

import com.reservationapp.entity.Bus;
import com.reservationapp.entity.Route;
import com.reservationapp.entity.SubRoutes;
import com.reservationapp.paylaod.BusDto;
import com.reservationapp.repository.BusRepository;
//import com.reservationapp.repository.DriverRepository;
import com.reservationapp.repository.RouteRepository;
import com.reservationapp.repository.SubRoutesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BusServiceImpl implements BusService{

    @Autowired
    private BusRepository busRepository;

    @Autowired
    private RouteRepository routeRepository;
    @Autowired
    private SubRoutesRepository subRoutesRepository;
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
        List<SubRoutes> subRoutes = bus.getSubRoutes();
        if (subRoutes != null) {
            for (SubRoutes subRoute : subRoutes) {
                subRoute.setBus(bus);
                subRoutesRepository.save(subRoute);
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
