package com.softserve.itacademy.dp_153.controller;

import com.softserve.itacademy.dp_153.model.User;
import com.softserve.itacademy.dp_153.service.UserService;
import com.softserve.itacademy.dp_153.util.dto.UserDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class UserController {
    @Autowired
    private UserService service;

    @GetMapping("/new")
    public String get(){
        UserDto dto = new UserDto();
        dto.setUserName("user");
        dto.setEmail("email");
        dto.setPassword("111");
        return service.createUser(dto);
    }

    @GetMapping("/email")
    public User findByEmail() {
        return service.findByEmail("email");
    }
}
