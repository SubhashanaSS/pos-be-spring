package com.ss.springpos.service;

import java.util.List;

import com.ss.springpos.entity.User;

public interface UserService {
    User createUser(User user);

    User getUser(String email);

    List<User> getAllUsers();

    User getUserById(int id);
}
