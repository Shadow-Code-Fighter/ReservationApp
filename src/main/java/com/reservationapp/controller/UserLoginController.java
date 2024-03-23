package com.reservationapp.controller;

import com.reservationapp.entity.CurrentUserSession;
import com.reservationapp.exception.LoginUserException;
import com.reservationapp.paylaod.UserLoginDto;
import com.reservationapp.service.UserLoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;



@RestController
@RequestMapping("/yatra")
public class UserLoginController {

    @Autowired
    private UserLoginService userLoginService;

    @PostMapping("/user/login")
    public ResponseEntity<CurrentUserSession> logInUser(@RequestBody UserLoginDto userLoginDto) throws LoginUserException {
        CurrentUserSession currentUserSession = userLoginService.userLogin(userLoginDto);
        return new ResponseEntity<CurrentUserSession>(currentUserSession, HttpStatus.ACCEPTED);
    }

    @PostMapping("/user/logout")
    public ResponseEntity<String> logoutUser(@RequestParam(required = false) String key) throws LoginUserException {
        String s = userLoginService.userLogout(key);
        return new ResponseEntity<>(s,HttpStatus.ACCEPTED);
    }
}
