package com.navi.rideshare.service.impl;

import com.navi.rideshare.model.User;
import com.navi.rideshare.model.Vehicle;
import com.navi.rideshare.service.VehicleService;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

public class VehicleServiceImpl implements VehicleService {

    private final Map<String, Map<String, Vehicle>> vehicleMap;

    public VehicleServiceImpl() {
        this.vehicleMap = new HashMap<>();
    }

    @Override
    public Vehicle createVehicle(User user, String name, String regNo) {
        String id = UUID.randomUUID().toString();
        Vehicle vehicle = new Vehicle(id, user, name, regNo);
        addVehicleToUser(user, vehicle);
        return vehicle;
    }

    private void addVehicleToUser(User user, Vehicle vehicle) {
        vehicleMap.computeIfAbsent(user.getId(), k -> new HashMap<>());
        vehicleMap.get(user.getId()).put(vehicle.getId(), vehicle);
    }

    @Override
    public Boolean validateVehicle(Vehicle vehicle) {
        String userID = vehicle.getUser().getId();
        String vehicleID = vehicle.getId();

        Map<String, Vehicle> userVehicles = vehicleMap.get(userID);
        if (userVehicles == null) {
            return false;
        }
        return userVehicles.get(vehicleID) != null;

    }
}
