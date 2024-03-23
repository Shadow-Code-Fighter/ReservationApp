package com.reservationapp.exception;

import lombok.NoArgsConstructor;

@NoArgsConstructor
public class LoginUserException extends Exception {
    public LoginUserException(String message) {
        super(message);
    }
}
