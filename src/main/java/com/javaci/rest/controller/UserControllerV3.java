package com.javaci.rest.controller;

import com.javaci.rest.model.User;
import com.javaci.rest.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api/v3/users")
public class UserControllerV3 {

    @Autowired
    private UserService userService;

    @GetMapping
    public List<User> getAllUsers() {
        return userService.getAllUsers();
    }

    @PostMapping
    public String createUser(@RequestBody User user) {

        return "User created: " + user;
    }

    @PutMapping
    public String updateUser(@RequestBody User user) {

        return "User created: " + user;
    }

    @DeleteMapping("/{user}")
    public String deleteUser(@PathVariable User user) {

        return "User not found";
    }
}
