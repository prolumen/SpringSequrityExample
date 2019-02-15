package com.softserve.itacademy.dp_153.controller;

import com.softserve.itacademy.dp_153.models.user.User;
import com.softserve.itacademy.dp_153.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api")
public class UserController {
    @Autowired
    private UserService service;

    @GetMapping("/email")
    public User findByEmail(@RequestParam String email) {
        return service.findByEmail(email);
    }

    @GetMapping("/users")
    public List<User> getAll() {
        return service.getAllUsers();
    }
    @GetMapping("/user")
    public User userAccount(String token) {
        return service.findByUsername(token);
    }
}
