package com.reservationapp.exception;

import lombok.NoArgsConstructor;

@NoArgsConstructor
public class BusDetailsNotFoundException extends Exception {
    public BusDetailsNotFoundException(String message) {
        super(message);
    }
}
