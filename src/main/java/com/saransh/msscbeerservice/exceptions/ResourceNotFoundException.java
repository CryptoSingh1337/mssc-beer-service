package com.saransh.msscbeerservice.exceptions;

/**
 * Created by CryptSingh1337 on 8/9/2021
 */
public class ResourceNotFoundException extends RuntimeException {

    public ResourceNotFoundException() {
    }

    public ResourceNotFoundException(String message) {
        super(message);
    }
}
