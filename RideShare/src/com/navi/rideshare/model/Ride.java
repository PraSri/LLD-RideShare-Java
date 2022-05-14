package com.navi.rideshare.model;

import com.navi.rideshare.model.enums.City;

public class Ride {
    private String id;
    private User user;
    private Vehicle vehicle;
    private City origin;
    private City destination;
    private Integer availableSeats;

    public Ride(String id, User user, Vehicle vehicle, City origin, City destination, Integer availableSeats) {
        this.id = id;
        this.user = user;
        this.vehicle = vehicle;
        this.origin = origin;
        this.destination = destination;
        this.availableSeats = availableSeats;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Vehicle getVehicle() {
        return vehicle;
    }

    public void setVehicle(Vehicle vehicle) {
        this.vehicle = vehicle;
    }

    public City getOrigin() {
        return origin;
    }

    public void setOrigin(City origin) {
        this.origin = origin;
    }

    public City getDestination() {
        return destination;
    }

    public void setDestination(City destination) {
        this.destination = destination;
    }

    public Integer getAvailableSeats() {
        return availableSeats;
    }

    public void setAvailableSeats(int availableSeats) {
        this.availableSeats = availableSeats;
    }

    @Override
    public String toString() {
        return "Ride{" +
                "id='" + id + '\'' +
                ", user=" + user +
                ", vehicle=" + vehicle +
                ", origin=" + origin +
                ", destination=" + destination +
                ", availableSeats=" + availableSeats +
                '}';
    }
}
