package com.softserve.itacademy.dp_153.controller;

import com.softserve.itacademy.dp_153.services.UserService;
import com.softserve.itacademy.dp_153.util.dto.UserDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SignUoController {
    @Autowired
    private UserService service;

    @PostMapping("/sign_up")
    public @ResponseBody
    String createUser(String firstName, String lastName, String username, String password) {
        return service.createUser(new UserDto(firstName, lastName, username, password));
    }

}
