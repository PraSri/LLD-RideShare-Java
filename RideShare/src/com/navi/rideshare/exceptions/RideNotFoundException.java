package com.navi.rideshare.exceptions;

public class RideNotFoundException extends RuntimeException {
    public RideNotFoundException(String message) {
        super(message);
    }
}
