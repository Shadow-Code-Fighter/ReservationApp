package com.reservationapp.service;

import com.reservationapp.entity.Bus;
import com.reservationapp.entity.Driver;
import com.reservationapp.exception.BusDetailsNotFoundException;
import com.reservationapp.exception.DriverDetailsNotFoundException;
import com.reservationapp.paylaod.DriverDto;
import com.reservationapp.repository.BusRepository;
import com.reservationapp.repository.DriverRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class DriverServiceImpl implements DriverService{

    @Autowired
    private DriverRepository driverRepository;

    @Autowired
    private ModelMapper modelMapper;

    @Autowired
    private BusRepository busRepository;

    @Override
    public DriverDto addDriver(DriverDto driverDto) throws BusDetailsNotFoundException, DriverDetailsNotFoundException {
        Bus bus = busRepository.findByBusNumber(driverDto.getBusNumber())
                .orElseThrow(() -> new BusDetailsNotFoundException("Bus Number Not Found"));

        Driver mapDriver = modelMapper.map(driverDto, Driver.class);
        mapDriver.setBus(bus);

        try {
            Driver saveDriver = driverRepository.save(mapDriver);
            return modelMapper.map(saveDriver, DriverDto.class);
        } catch (DataIntegrityViolationException e) {
            // Handle constraint violation exceptions here
            throw new DriverDetailsNotFoundException("Driver details not valid or already exists "+e);
        } catch (Exception e) {
            // Handle other exceptions here
            throw new RuntimeException("Error occurred while adding driver", e);
        }
    }
}
