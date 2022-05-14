package com.navi.rideshare.factory.strategy.impl;

import com.navi.rideshare.factory.strategy.RideSelectionStrategy;
import com.navi.rideshare.model.Ride;
import com.navi.rideshare.model.User;

import java.util.List;

public class UnknownStrategy implements RideSelectionStrategy {

    @Override
    public Ride selectRide(List<Ride> rides, User user, int requiredSeats, String preference) {
        return null;
    }
}
