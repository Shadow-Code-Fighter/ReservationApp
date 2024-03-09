package com.reservationapp.service;

import com.reservationapp.entity.Bus;
import com.reservationapp.entity.BusStops;
import com.reservationapp.exception.BusDetailsNotFoundException;
import com.reservationapp.paylaod.StopsDto;
import com.reservationapp.repository.BusRepository;
import com.reservationapp.repository.BusStopsRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class StopServiceImpl implements StopService{

    @Autowired
    private BusStopsRepository busStopsRepository;

    @Autowired
    private ModelMapper modelMapper;

    @Autowired
    private BusRepository busRepository;

    @Override
    public StopsDto addBusStops(StopsDto stopsDto) throws BusDetailsNotFoundException {
        Bus bus = busRepository.findByBusNumber(stopsDto.getBusNumber())
                .orElseThrow(() -> new BusDetailsNotFoundException("Bus Number Not Found"+stopsDto));

        BusStops mapBusStops = modelMapper.map(stopsDto, BusStops.class);
        mapBusStops.setBus(bus);
        BusStops saveBusStops = busStopsRepository.save(mapBusStops);
        StopsDto mapStopsDto = modelMapper.map(saveBusStops, StopsDto.class);
        return mapStopsDto;
    }
}
