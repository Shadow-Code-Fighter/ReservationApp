package com.reservationapp.service;

import com.reservationapp.entity.Bus;
import com.reservationapp.entity.Stops;
import com.reservationapp.exception.BusDetailsNotFoundException;
import com.reservationapp.paylaod.StopsDto;
import com.reservationapp.repository.BusRepository;
import com.reservationapp.repository.StopsRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class StopServiceImpl implements StopService{

    @Autowired
    private StopsRepository stopsRepository;

    @Autowired
    private ModelMapper modelMapper;

    @Autowired
    private BusRepository busRepository;

    @Override
    public StopsDto addStops(StopsDto stopsDto) throws BusDetailsNotFoundException {
        Bus bus = busRepository.findByBusNumber(stopsDto.getBusNumber())
                .orElseThrow(() -> new BusDetailsNotFoundException("Bus Number Not Found"+stopsDto));

        Stops mapStops = modelMapper.map(stopsDto, Stops.class);
        mapStops.setBus(bus);
        Stops saveStops = stopsRepository.save(mapStops);
        StopsDto mapStopsDto = modelMapper.map(saveStops, StopsDto.class);
        return mapStopsDto;
    }
}
