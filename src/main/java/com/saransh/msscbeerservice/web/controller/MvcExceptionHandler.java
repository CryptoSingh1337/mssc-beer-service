package com.saransh.msscbeerservice.web.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageConversionException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

/**
 * Created by CryptoSingh1337 on 7/25/2021
 */
@ControllerAdvice
public class MvcExceptionHandler {

    @ExceptionHandler(HttpMessageConversionException.class)
    public ResponseEntity<?> messageConversionHandler(HttpMessageConversionException e) {
        return new ResponseEntity<>(
                "Invalid Beer style",
                HttpStatus.BAD_REQUEST
        );
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<?> validationErrorHandler(MethodArgumentNotValidException e) {
        return new ResponseEntity<>(
                e.getFieldErrors(),
                HttpStatus.BAD_REQUEST
        );
    }
}
