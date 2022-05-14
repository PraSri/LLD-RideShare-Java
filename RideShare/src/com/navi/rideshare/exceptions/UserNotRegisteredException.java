package com.navi.rideshare.exceptions;

public class UserNotRegisteredException extends RuntimeException {
    public UserNotRegisteredException(String message) {
        super(message);
    }
}
