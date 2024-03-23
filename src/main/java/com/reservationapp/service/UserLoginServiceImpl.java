package com.reservationapp.service;


import com.reservationapp.entity.CurrentUserSession;
import com.reservationapp.entity.User;
import com.reservationapp.exception.LoginUserException;
import com.reservationapp.paylaod.UserLoginDto;
import com.reservationapp.repository.CurrentUserSessionRepository;
import com.reservationapp.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.security.SecureRandom;
import java.time.LocalDateTime;
import java.util.Base64;
import java.util.Optional;

@Service
public class UserLoginServiceImpl implements UserLoginService{

    @Autowired
    private UserRepository userRepository;
    @Autowired
    private CurrentUserSessionRepository currentUserSessionRepository;

    @Override
    public CurrentUserSession userLogin(UserLoginDto userLoginDto) throws LoginUserException {
        User registeredUser = userRepository.findByEmail(userLoginDto.getEmail());
        if (registeredUser==null) throw new LoginUserException("Please insert valid Email Id: ");

        Optional<CurrentUserSession> loggedIdUser = currentUserSessionRepository.findById(registeredUser.getUserId());
        if (loggedIdUser.isPresent()) throw new LoginUserException("User already logged");

        if(registeredUser.getPassword().equals(userLoginDto.getPassword())){
            SecureRandom secureRandom = new SecureRandom();
            byte[] keyBytes = new byte[10];
            secureRandom.nextBytes(keyBytes);

            String key = Base64.getEncoder().encodeToString(keyBytes);

            CurrentUserSession currentUserSession = new CurrentUserSession();
            currentUserSession.setUserID(registeredUser.getUserId());
            currentUserSession.setUuid(key);
            currentUserSession.setTime(LocalDateTime.now());

            return currentUserSessionRepository.save(currentUserSession);
        }else {
          throw new LoginUserException("Please enter a valid password");
        }
    }

    @Override
    public String userLogout(String key) throws LoginUserException {
        CurrentUserSession loggedInUser = currentUserSessionRepository.findByUuid(key);
        if (loggedInUser==null) throw new LoginUserException("Please enter valid Uuid(key):"+key);
        currentUserSessionRepository.delete(loggedInUser);
        return "User logout";
    }
}
