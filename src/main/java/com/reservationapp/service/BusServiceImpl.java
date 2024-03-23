package com.reservationapp.service;

import com.reservationapp.entity.Bus;
import com.reservationapp.entity.Route;
import com.reservationapp.entity.BusStops;
import com.reservationapp.paylaod.BusDto;
import com.reservationapp.paylaod.SearchListOfBusesDto;
import com.reservationapp.paylaod.StopDto;
import com.reservationapp.repository.BusRepository;
import com.reservationapp.repository.RouteRepository;
import com.reservationapp.repository.BusStopsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class BusServiceImpl implements BusService{

    @Autowired
    private BusRepository busRepository;

    @Autowired
    private RouteRepository routeRepository;
    @Autowired
    private BusStopsRepository busStopsRepository;

    @Autowired
    private ModelMapper modelMapper;

    @Override
    public BusDto addBus(BusDto busDto) {
        // Map BusDto to Bus entity
        Bus bus = modelMapper.map(busDto, Bus.class);

        // Save associated Route entity
        Route route = bus.getRoute();
        routeRepository.save(route);

        // Save associated SubRoutes entities
        List<BusStops> stop = bus.getStop();
        if (stop != null) {
            for (BusStops stopBus : stop) {
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
    public BusDto getBusById(long busId) {
        Bus bus = busRepository.findById(busId).orElse(null);
        List<BusStops> allWithBusId = busStopsRepository.findAllWithBusId();
        BusDto mapToDto = modelMapper.map(bus, BusDto.class);
        mapToDto.setStops(allWithBusId);
        return mapToDto;
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

    @Transactional
    @Override
    public void deleteBusByBusId(long busId) {
        busRepository.deleteById(busId);
    }

    @Override
    public void deleteRouteByRouteId(long routeId) {
        routeRepository.deleteById(routeId);
    }

    @Override
    public List<SearchListOfBusesDto> getAllBuses(String routeFrom, String routeTo, String fromDate) {
        List<Route> routeList = routeRepository.findByRouteFromAndRouteToAndFromDate(routeFrom, routeTo, fromDate);
//        System.out.println(routeList);
        List<SearchListOfBusesDto> buses = new ArrayList<>();
            for (Route route:routeList){
                Bus bus = busRepository.findById(route.getId()).get();
                SearchListOfBusesDto searchListOfBusesDto = mapToSearchListOfBusesDto(bus, route);
                buses.add(searchListOfBusesDto);
            }
            return buses;
        }

        SearchListOfBusesDto mapToSearchListOfBusesDto(Bus bus, Route route){
            SearchListOfBusesDto searchListOfBusesDto = new SearchListOfBusesDto();
            modelMapper.map(bus,searchListOfBusesDto);
            modelMapper.map(route,searchListOfBusesDto);
            return searchListOfBusesDto;
        }
    }
