package com.navi.rideshare.factory.strategy.impl;

import com.navi.rideshare.factory.strategy.RideSelectionStrategy;
import com.navi.rideshare.model.Ride;
import com.navi.rideshare.model.User;

import java.util.List;

public class PreferredVehicleStrategy implements RideSelectionStrategy {
    @Override
    public Ride selectRide(List<Ride> rides, User user, int requiredSeats, String preference) {
        if (!rides.isEmpty()) {
            List<Ride> preferredRides = rides
                    .stream()
                    .filter(ride -> !ride.getUser().getId().equals(user.getId()))
                    .filter(x -> x.getVehicle().getName().equalsIgnoreCase(preference))
                    .toList();
            if (!preferredRides.isEmpty()) {
                for (Ride ride : preferredRides) {
                    if (requiredSeats <= ride.getAvailableSeats()) {
                        return ride;
                    }
                }
            }
        }
        return null;
    }
}
