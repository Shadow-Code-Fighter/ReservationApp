package com.reservationapp.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;

import java.time.LocalDateTime;

@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(BusDetailsNotFoundException.class)
    public ResponseEntity<ErrorDetails> busNotFoundHandler(BusDetailsNotFoundException e,WebRequest w){
        ErrorDetails error = new ErrorDetails();
        error.setTime(LocalDateTime.now());
        error.setMessage(e.getMessage());
        error.setDetails(w.getDescription(false));
        return new ResponseEntity<>(error,HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(DriverDetailsNotFoundException.class)
    public ResponseEntity<ErrorDetails> driverNotFoundHandler(DriverDetailsNotFoundException e,WebRequest w){
        ErrorDetails error = new ErrorDetails();
        error.setTime(LocalDateTime.now());
        error.setMessage(e.getMessage());
        error.setDetails(w.getDescription(false));
        return new ResponseEntity<>(error,HttpStatus.BAD_REQUEST);
    }
    @ExceptionHandler(LoginUserException.class)
    public ResponseEntity<ErrorDetails> loginException(LoginUserException e,WebRequest w){
        ErrorDetails error = new ErrorDetails();
        error.setTime(LocalDateTime.now());
        error.setMessage(e.getMessage());
        error.setDetails(w.getDescription(false));
        return new ResponseEntity<>(error,HttpStatus.BAD_REQUEST);
    }

}
