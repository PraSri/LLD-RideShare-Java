package com.navi.rideshare.service;

import com.navi.rideshare.model.User;
import com.navi.rideshare.model.Vehicle;

public interface VehicleService {
    Vehicle createVehicle(User user, String name, String regNo);

    Boolean validateVehicle(Vehicle vehicle);
}
