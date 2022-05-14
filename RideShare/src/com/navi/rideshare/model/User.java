package com.navi.rideshare.model;

import com.navi.rideshare.model.enums.Gender;

import java.util.Objects;

public class User {

    private final String id;
    private final String name;
    private final Gender gender;
    private final int age;

    public User(String id, String name, Gender gender, int age) {
        this.id = id;
        this.name = name;
        this.gender = gender;
        this.age = age;
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public Gender getGender() {
        return gender;
    }

    public int getAge() {
        return age;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return age == user.age && Objects.equals(id, user.id) && Objects.equals(name, user.name) && gender == user.gender;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, gender, age);
    }

    @Override
    public String toString() {
        return "User{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", gender=" + gender +
                ", age=" + age +
                '}';
    }
}
