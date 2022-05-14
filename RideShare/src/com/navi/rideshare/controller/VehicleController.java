package com.navi.rideshare.controller;

import com.navi.rideshare.exceptions.UserNotRegisteredException;
import com.navi.rideshare.model.User;
import com.navi.rideshare.model.Vehicle;
import com.navi.rideshare.service.UserService;
import com.navi.rideshare.service.VehicleService;

public class VehicleController {

    private final VehicleService vehicleService;
    private final UserService userService;

    public VehicleController(VehicleService vehicleService, UserService userService) {
        this.vehicleService = vehicleService;
        this.userService = userService;
    }

    public Vehicle createVehicle(User user, String name, String regNo) {
        if (!userService.validateUser(user)) {
            throw new UserNotRegisteredException("user is not registered user name: " + user.getName() + "user id: " + user.getName());
        }
        return vehicleService.createVehicle(user, name, regNo);
    }
}
