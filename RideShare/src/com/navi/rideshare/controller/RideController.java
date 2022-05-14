package com.navi.rideshare.controller;

import com.navi.rideshare.exceptions.UserNotRegisteredException;
import com.navi.rideshare.exceptions.VehicleNotRegisteredForUserException;
import com.navi.rideshare.model.Ride;
import com.navi.rideshare.model.User;
import com.navi.rideshare.model.Vehicle;
import com.navi.rideshare.model.enums.City;
import com.navi.rideshare.model.enums.RideSelectionType;
import com.navi.rideshare.service.RideService;
import com.navi.rideshare.service.UserService;
import com.navi.rideshare.service.VehicleService;

import java.util.List;

public class RideController {
    private UserService userService;
    private VehicleService vehicleService;
    private RideService rideService;

    public RideController(UserService userService, VehicleService vehicleService, RideService rideService) {
        this.userService = userService;
        this.vehicleService = vehicleService;
        this.rideService = rideService;
    }

    public Ride createRide(User user, Vehicle vehicle, City origin, City destination, int availableSeats) {
        if (!userService.validateUser(user)) {
            throw new UserNotRegisteredException("user is not regitstered. user name: " + user.getName() + "user id: " + user.getName());
        }
        if (!vehicleService.validateVehicle(vehicle)) {
            throw new VehicleNotRegisteredForUserException("No vehicle registered for user :" + user);
        }
        return rideService.createRide(user, vehicle, origin, destination, availableSeats);
    }

    public List<Ride> offeredRides(User user) {
        return rideService.offeredRides(user);
    }

    public List<Ride> takenRides(User user) {
        return rideService.takenRides(user);
    }

    public Ride selectRide(User user, City origin, City destination, int requiredSeats, String selectionStrategy) {
        try {
            RideSelectionType rideType;
            String preferredVehicle = null;
            if ("Most Vacant".equals(selectionStrategy)) {
                rideType = RideSelectionType.MOST_VACANT;
            } else {
                preferredVehicle = selectionStrategy;
                rideType = RideSelectionType.PREFERRED_VEHICLE;
            }
            return rideService.selectRide(user, origin, destination, requiredSeats, rideType, preferredVehicle);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return null;
    }
}
