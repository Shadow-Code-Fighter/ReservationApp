package com.reservationapp.exception;

import lombok.NoArgsConstructor;

@NoArgsConstructor
public class RouteDetailsNotFoundException extends Exception {
    public RouteDetailsNotFoundException(String message) {
        super(message);
    }
}
