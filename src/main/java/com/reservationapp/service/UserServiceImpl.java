package com.reservationapp.service;

import com.reservationapp.entity.User;
import com.reservationapp.paylaod.UserRegistrationDto;
import com.reservationapp.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
//@RequiredArgsConstructor
public class UserServiceImpl {
    @Autowired
    private UserRepository userRegistrationRepository;

    public UserRegistrationDto createUser(User userRegistration){
        userRegistrationRepository.save(userRegistration);
       return null;
    }

    public User getUserById(long id) {
        return userRegistrationRepository.findById(id).get();
    }
}
