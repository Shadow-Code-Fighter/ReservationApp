package com.reservationapp.service;

import com.reservationapp.entity.CurrentUserSession;
import com.reservationapp.exception.LoginUserException;
import com.reservationapp.paylaod.UserLoginDto;


public interface UserLoginService {
    CurrentUserSession userLogin(UserLoginDto userLoginDto) throws LoginUserException;

    String userLogout(String key) throws LoginUserException;
}
