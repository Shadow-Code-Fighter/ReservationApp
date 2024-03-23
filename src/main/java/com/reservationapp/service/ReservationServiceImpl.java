package com.reservationapp.service;

import com.reservationapp.entity.Bus;
import com.reservationapp.entity.Passenger;
import com.reservationapp.entity.Route;
import com.reservationapp.repository.BusRepository;
import com.reservationapp.repository.BusStopsRepository;
import com.reservationapp.repository.PassengerRepository;
import com.reservationapp.repository.RouteRepository;
import com.reservationapp.util.EmailService;
import com.reservationapp.util.PdfTicketGeneratorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ReservationServiceImpl implements ReservationService{

    @Autowired
    private BusRepository busRepository;

    @Autowired
    private PassengerRepository passengerRepository;

    @Autowired
    private RouteRepository routeRepository;
    @Autowired
    private BusStopsRepository stopsRepository;

    @Autowired
    private PdfTicketGeneratorService pdfTicketGeneratorService;

    @Autowired
    private EmailService emailService;
    public void bookTicket(long busId, long routeId, Passenger passenger)  {
        boolean busIsPresent = false;
        boolean routeIsPresent = false;
        Optional<Bus> busID = busRepository.findById(busId);
        if (busID.isPresent()){
            busIsPresent=true;
            Bus bus = busID.get();
        }
        Optional<Route> routeID = routeRepository.findById(routeId);
        if (routeID.isPresent()){
            routeIsPresent=true;
            Route route = routeID.get();
        }
        if (busIsPresent&&routeIsPresent) {
            //Add Passenger Details
            Passenger p = new Passenger();
            p.setFirstName(passenger.getFirstName());
            p.setLastName(passenger.getLastName());
            p.setEmail(passenger.getEmail());
            p.setMobile(passenger.getMobile());
            p.setBusId(busId);
            p.setRouteId(routeId);
            Passenger savePassengerDetails = passengerRepository.save(p);
            byte[] pdfBytes = pdfTicketGeneratorService.generateTicket(savePassengerDetails, busID.get().getFromLocation(), busID.get().getToLocation(), busID.get().getFromDate());
            emailService.sendEmailWithAttachment(passenger.getEmail(), "Booking confirm", "your Reservation id" + savePassengerDetails.getId(), pdfBytes, "Ticket");
        }
    }
}
