package com.reservationapp.service;

import com.reservationapp.entity.Bus;
import com.reservationapp.entity.BusStops;
import com.reservationapp.exception.BusDetailsNotFoundException;
import com.reservationapp.exception.BusStopsNotFoundException;
import com.reservationapp.paylaod.BusStopsDto;
import com.reservationapp.repository.BusRepository;
import com.reservationapp.repository.BusStopsRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BusStopServiceImpl implements BusStopService {

    @Autowired
    private BusStopsRepository busStopsRepository;

    @Autowired
    private ModelMapper modelMapper;

    @Autowired
    private BusRepository busRepository;

    @Override
    public BusStopsDto addBusStops(BusStopsDto busStopsDto) throws BusDetailsNotFoundException {
        Bus bus = busRepository.findByBusNumber(busStopsDto.getBusNumber())
                .orElseThrow(() -> new BusDetailsNotFoundException("Bus Number Not Found"+ busStopsDto));

        BusStops mapBusStops = modelMapper.map(busStopsDto, BusStops.class);
        mapBusStops.setBus(bus);
        BusStops saveBusStops = busStopsRepository.save(mapBusStops);
        BusStopsDto mapBusStopsDto = modelMapper.map(saveBusStops, BusStopsDto.class);
        return mapBusStopsDto;
    }

    @Override
    public List<BusStops> viewBusStops() {
        List<BusStops> allBusStops = busStopsRepository.findAllWithBusId();
        return allBusStops;
    }

    @Override
    public List<BusStops> viewByLocationName(String location) {
        List<BusStops> byLocation = busStopsRepository.findByLocation(location);
        return byLocation;
    }

}
