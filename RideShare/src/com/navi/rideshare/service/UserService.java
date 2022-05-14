package com.navi.rideshare.service;

import com.navi.rideshare.model.User;
import com.navi.rideshare.model.enums.Gender;

public interface UserService {
    User addUser(String name, Gender gender, int age);

    Boolean validateUser(User user);
}
