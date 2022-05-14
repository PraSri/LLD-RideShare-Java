package com.navi.rideshare.exceptions;

public class RideNotAllowedException extends RuntimeException {
    public RideNotAllowedException(String message) {
        super(message);
    }
}
