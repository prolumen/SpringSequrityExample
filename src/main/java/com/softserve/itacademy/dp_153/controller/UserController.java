package com.softserve.itacademy.dp_153.controller;

import com.softserve.itacademy.dp_153.models.user.User;
import com.softserve.itacademy.dp_153.services.UserService;
import com.softserve.itacademy.dp_153.util.dto.UserDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class UserController {
    @Autowired
    private UserService service;

    @PostMapping("/sign_up")
    public @ResponseBody String createUser(String firstName, String lastName, String username, String password) {
        return service.createUser(new UserDto(firstName, lastName, username, password));
    }

    @GetMapping("/email")
    public User findByEmail(@RequestParam String email) {
        return service.findByEmail(email);
    }

    @GetMapping("/users")
    public List<User> getAll() {
        return service.getAllUsers();
    }
}
