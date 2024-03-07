package com.reservationapp.exception;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@NoArgsConstructor
public class DriverDetailsNotFoundException extends Exception{
    public DriverDetailsNotFoundException(String message) {
        super(message);
    }
}
