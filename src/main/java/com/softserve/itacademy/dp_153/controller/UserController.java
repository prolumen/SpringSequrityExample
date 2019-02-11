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
    public @ResponseBody String createUser(@RequestParam String userName,
                                           @RequestParam String email,
                                           @RequestParam String password,
                                           @RequestParam String role){
        System.out.println(userName);
        return service.createUser(setUserDto(userName, email, password, role));
    }

    @GetMapping("/email")
    public User findByEmail(@RequestParam String email) {
        return service.findByEmail(email);
    }

    @GetMapping()
    public List<User> getAll() {
        System.out.println("hi hitler");
        return service.getAllUsers();
    }

//    @PutMapping()
//    public @ResponseBody String updateUser(@RequestParam String userName,
//                                           @RequestParam String email,
//                                           @RequestParam String password) {
//        return service.createUser(setUserDto(userName, email, password));
//    }

    private UserDto setUserDto(String userName, String email, String password, String role) {
        UserDto dto = new UserDto();
        dto.setUserName(userName);
        dto.setEmail(email);
        dto.setPassword(password);
        dto.setRole(role);
        return dto;
    }
}
