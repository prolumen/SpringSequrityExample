package com.softserve.itacademy.dp_153.controller;

import com.softserve.itacademy.dp_153.model.User;
import com.softserve.itacademy.dp_153.service.UserService;
import com.softserve.itacademy.dp_153.util.dto.UserDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class UserController {
    @Autowired
    private UserService service;

    @PostMapping()
    public @ResponseBody String signUp(@RequestParam String userName,
                                     @RequestParam String email,
                                     @RequestParam String password){
        UserDto dto = new UserDto();
        dto.setUserName(userName);
        dto.setEmail(email);
        dto.setPassword(password);
        return service.createUser(dto);
    }

    @GetMapping("/user")
    public User findByEmail(@RequestParam String email) {
        return service.findByEmail(email);
    }

    @GetMapping(/*"/users"*/)
    public List<User> getAll() {
        return service.getAllUsers();
    }
}
