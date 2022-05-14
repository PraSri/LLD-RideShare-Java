package com.navi.rideshare.factory.strategy.impl;

import com.navi.rideshare.factory.strategy.RideSelectionStrategy;
import com.navi.rideshare.model.Ride;
import com.navi.rideshare.model.User;

import java.util.Comparator;
import java.util.List;

public class MostVacantStrategy implements RideSelectionStrategy {
    @Override
    public Ride selectRide(List<Ride> rides, User user, int requiredSeats, String preference) {
        if (!rides.isEmpty()) {
            List<Ride> processList = rides
                    .stream()
                    .filter(ride -> !ride.getUser().getId().equals(user.getId()))
                    .sorted(Comparator.comparing(Ride::getAvailableSeats))
                    .toList();
            if (!processList.isEmpty()) {
                for (Ride ride : processList) {
                    if (requiredSeats <= ride.getAvailableSeats()) {
                        return ride;
                    }
                }
            }
        }
        return null;
    }
}
