package com.ss.springpos.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ss.springpos.entity.User;
import com.ss.springpos.service.UserService;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/user")
public class UserController {
    @Autowired
    private UserService userService;

    @PostMapping
    public ResponseEntity<User> addUser(@RequestBody User user) {
        User createdUser = userService.createUser(user);
        return ResponseEntity.status(201).body(createdUser);
    }

    @GetMapping("/{email}")
    public ResponseEntity<User> getUser(@PathVariable String email) {
        User user = userService.getUser(email);

        if (user != null) {
            return ResponseEntity.status(200).body(user);
        }else {
            return ResponseEntity.status(404).body(null);
        }
    }

    @GetMapping
    public ResponseEntity<List<User>> getAllUsers() {
        List<User> users = userService.getAllUsers();
        return ResponseEntity.status(200).body(users);
    }
}
