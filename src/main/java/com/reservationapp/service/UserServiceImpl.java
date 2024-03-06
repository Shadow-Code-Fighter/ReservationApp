package com.reservationapp.service;

import com.reservationapp.entity.UserRegistration;
import com.reservationapp.paylaod.UserRegistrationDto;
import com.reservationapp.repository.UserRegistrationRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
//@RequiredArgsConstructor
public class UserServiceImpl {
    @Autowired
    private UserRegistrationRepository userRegistrationRepository;

    public UserRegistrationDto createUser(UserRegistration userRegistration){
        userRegistrationRepository.save(userRegistration);
       return null;
    }

    public UserRegistration getUserById(long id) {
        return userRegistrationRepository.findById(id).get();
    }
}
