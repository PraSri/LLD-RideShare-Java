package com.navi.rideshare.controller;

import com.navi.rideshare.model.User;
import com.navi.rideshare.model.enums.Gender;
import com.navi.rideshare.service.UserService;

public class UserController {
    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    public User createUser(String name, Gender gender, int age) {
        return userService.addUser(name, gender, age);
    }
}
