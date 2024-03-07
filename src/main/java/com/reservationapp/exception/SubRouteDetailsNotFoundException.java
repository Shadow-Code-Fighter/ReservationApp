package com.reservationapp.exception;

import lombok.NoArgsConstructor;

@NoArgsConstructor
public class SubRouteDetailsNotFoundException extends Exception {
    public SubRouteDetailsNotFoundException(String message) {
    super(message);
    }
}
