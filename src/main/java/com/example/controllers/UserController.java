package com.example.controllers;
import com.example.models.User;
import com.example.services.UserService;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping("/users")
    public List<User> getUsers() {
        return userService.findAll();
    }

    @RequestMapping("/users/{userId}")
    public User findUser(@PathVariable Long userId) {
        User user = userService.findById(userId);
        return user;
    }

    @GetMapping("/users/count")
    public Long count() {
        return userService.count();
    }

    @PostMapping("/users")
    void addUser(@RequestBody User user) {
        userService.save(user);
    }
}