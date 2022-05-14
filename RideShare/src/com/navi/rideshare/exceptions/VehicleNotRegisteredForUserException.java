package com.navi.rideshare.exceptions;

public class VehicleNotRegisteredForUserException extends RuntimeException {
    public VehicleNotRegisteredForUserException(String message) {
        super(message);
    }
}
