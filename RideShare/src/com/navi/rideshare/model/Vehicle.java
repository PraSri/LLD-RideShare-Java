package com.navi.rideshare.model;

public class Vehicle {

    private final String id;
    private final User user;
    private final String name;
    private final String regNo;

    public Vehicle(String id, User user, String name, String regNo) {
        this.id = id;
        this.user = user;
        this.name = name;
        this.regNo = regNo;
    }

    public String getId() {
        return id;
    }

    public User getUser() {
        return user;
    }

    public String getName() {
        return name;
    }

    public String getRegNo() {
        return regNo;
    }

    @Override
    public String toString() {
        return "Vehicle{" +
                "id='" + id + '\'' +
                ", user=" + user +
                ", name='" + name + '\'' +
                ", regNo='" + regNo + '\'' +
                '}';
    }
}
