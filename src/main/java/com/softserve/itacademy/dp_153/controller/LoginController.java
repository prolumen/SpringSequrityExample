package com.softserve.itacademy.dp_153.controller;

import com.softserve.itacademy.dp_153.services.LoginService;
import com.softserve.itacademy.dp_153.util.dto.TokenDto;
import com.softserve.itacademy.dp_153.util.dto.UserDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class LoginController {
    @Autowired
    private LoginService service;

    @PostMapping("/login")
    public ResponseEntity<TokenDto> login(String username, String password) {
        UserDto dto = new UserDto();
        dto.setUsername(username);
        dto.setPassword(password);
        try {

            return ResponseEntity.ok(service.login(dto));
        } catch (IllegalArgumentException e) {
            System.out.println("///////////\n///////////////////\n/////////////////////\n///////////////////////");
            return (ResponseEntity<TokenDto>) ResponseEntity.badRequest();
        }
    }
}
