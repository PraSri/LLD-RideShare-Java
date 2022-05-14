package com.navi.rideshare.service;

import com.navi.rideshare.model.Ride;
import com.navi.rideshare.model.User;
import com.navi.rideshare.model.Vehicle;
import com.navi.rideshare.model.enums.City;
import com.navi.rideshare.model.enums.RideSelectionType;

import java.util.List;

public interface RideService {
    Ride createRide(User user, Vehicle vehicle, City origin, City destination, int availableSeats);

    Ride selectRide(User user, City origin, City destination, int requiredSeats, RideSelectionType rideType, String preferredVehicle);

    List<Ride> offeredRides(User user);

    List<Ride> takenRides(User user);

    void printAllMaps();
}
