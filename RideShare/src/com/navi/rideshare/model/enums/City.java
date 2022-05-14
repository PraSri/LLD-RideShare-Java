package com.navi.rideshare.model.enums;

public enum City {

    DELHI("DELHI"),
    NOIDA("NOIDA"),
    HYDERABAD("HYDERABAD"),
    BANGALORE("BANGALORE"),
    MYSORE("MYSORE"),
    MUMBAI("MUMBAI"),
    PUNE("PUNE"),
    OTHER("OTHER");

    private final String text;

    City(String text) {
        this.text = text;
    }

    public City fromString(String text) {
        for (City city : City.values()) {
            if (city.text.equalsIgnoreCase(text.trim())) {
                return city;
            }
        }
        return null;
    }
}
