package com.navi.rideshare.service.impl;

import com.navi.rideshare.model.User;
import com.navi.rideshare.model.enums.Gender;
import com.navi.rideshare.service.UserService;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

public class UserServiceImpl implements UserService {

    public Map<String, User> userMap;

    public UserServiceImpl() {
        userMap = new HashMap<>();
    }

    @Override
    public User addUser(String name, Gender gender, int age) {
        String id = UUID.randomUUID().toString();
        User user = new User(id, name, gender, age);
        userMap.put(user.getId(), user);
        return user;
    }

    @Override
    public Boolean validateUser(User user) {
        return userMap.get(user.getId()) != null;
    }
}
