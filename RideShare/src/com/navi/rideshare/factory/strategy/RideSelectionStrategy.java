package com.navi.rideshare.factory.strategy;

import com.navi.rideshare.model.Ride;
import com.navi.rideshare.model.User;

import java.util.List;

public interface RideSelectionStrategy {
    Ride selectRide(List<Ride> rides, User user, int requiredSeats, String preference);
}
