package com.navi.rideshare.service.impl;

import com.navi.rideshare.exceptions.RideNotAllowedException;
import com.navi.rideshare.exceptions.RideNotFoundException;
import com.navi.rideshare.factory.RideStrategyFactory;
import com.navi.rideshare.factory.strategy.RideSelectionStrategy;
import com.navi.rideshare.model.Ride;
import com.navi.rideshare.model.User;
import com.navi.rideshare.model.Vehicle;
import com.navi.rideshare.model.enums.City;
import com.navi.rideshare.model.enums.RideSelectionType;
import com.navi.rideshare.service.RideService;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

public class RideServiceImpl implements RideService {
    private Map<User, List<Ride>> offeredRideMap;
    private Map<String, List<Ride>> originDestinationRideMap;
    private RideStrategyFactory rideStrategyFactory;
    private Map<User, List<Ride>> takenRideMap;

    public RideServiceImpl() {
        this.offeredRideMap = new HashMap<>();
        this.originDestinationRideMap = new HashMap<>();
        this.rideStrategyFactory = new RideStrategyFactory();
        this.takenRideMap = new HashMap<>();
    }

    @Override
    public Ride createRide(User user, Vehicle vehicle, City origin, City destination, int availableSeats) {
        String id = UUID.randomUUID().toString();
        Ride ride = new Ride(id, user, vehicle, origin, destination, availableSeats);
        offeredRideMap.computeIfAbsent(user, k -> new ArrayList<>()).add(ride);
        String originDestinationKey = createOriginDestinationKey(origin, destination);
        originDestinationRideMap.computeIfAbsent(originDestinationKey, k -> new ArrayList<>()).add(ride);
        return ride;
    }

    @Override
    public Ride selectRide(User user, City origin, City destination, int requiredSeats, RideSelectionType rideType, String preference) {
        if (RideSelectionType.PREFERRED_VEHICLE == rideType && preference == null) {
            throw new RideNotAllowedException("Provide preferred vehicle for strategy : " + rideType);
        }
        String originDestinationKey = createOriginDestinationKey(origin, destination);
        List<Ride> rides = originDestinationRideMap.getOrDefault(originDestinationKey, Collections.emptyList());
        RideSelectionStrategy rideSelectionStrategy = rideStrategyFactory.findStrategy(rideType);
        Ride ride = rideSelectionStrategy.selectRide(rides, user, requiredSeats, preference);
        if (ride == null) {
            throw new RideNotFoundException("No ride found for selection type : " + rideType);
        }
        takenRideMap.computeIfAbsent(user, k -> new ArrayList<>()).add(ride);
        ride.setAvailableSeats(ride.getAvailableSeats() - requiredSeats);
        return ride;
    }

    private String createOriginDestinationKey(City origin, City destination) {
        return origin + "->" + destination;
    }

    @Override
    public List<Ride> offeredRides(User user) {
        List<Ride> rides = offeredRideMap.get(user);
        return rides != null ? rides : Collections.emptyList();
    }

    @Override
    public List<Ride> takenRides(User user) {
        List<Ride> rides = takenRideMap.get(user);
        return rides != null ? rides : Collections.emptyList();
    }

    public void printAllMaps() {

        System.out.println("*****RIDE_SERVICE_MAPS************");

        System.out.println("offeredRideMap");
        int i = 1;
        for (Map.Entry<User, List<Ride>> me : offeredRideMap.entrySet())
            System.out.println(i++ + ". " + me.getKey() + "->" + me.getValue().size());

        System.out.println("originDestinationRideMap");

        i = 1;
        for (Map.Entry<String, List<Ride>> me : originDestinationRideMap.entrySet())
            System.out.println(i++ + ". " + me.getKey() + "->" + me.getValue().size());

        System.out.println("takenRideMap");

        i = 1;
        for (Map.Entry<User, List<Ride>> me : takenRideMap.entrySet())
            System.out.println(i++ + ". " + me.getKey() + "->" + me.getValue().size());
    }

}
