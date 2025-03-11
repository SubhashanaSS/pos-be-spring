package com.ss.springpos.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ss.springpos.entity.User;
import com.ss.springpos.repository.UserRepository;
import com.ss.springpos.service.UserService;

@Service
public class UserServiceImpl implements UserService{
    @Autowired
    private UserRepository userRepository;

    @Override
    public User createUser(User user) {
        return userRepository.save(user);
    }

    @Override
    public User getUser(String email) {
        Optional<User> optionalUser = userRepository.findByEmail(email);

        if (optionalUser.isPresent()) {
            return optionalUser.get();
        } else {
            return null;  // or throw a custom exception if needed
        }
    }


    @Override
    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    @Override
    public User getUserById(int id) {
        return userRepository.findById(id).get();
    }
}
