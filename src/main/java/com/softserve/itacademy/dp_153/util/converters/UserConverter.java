package com.softserve.itacademy.dp_153.util.converters;

import com.softserve.itacademy.dp_153.model.User;
import com.softserve.itacademy.dp_153.util.dto.UserDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class UserConverter {
    @Autowired
    UserDto dto;

    public User asUser(UserDto userDto) {
        User user = new User();
        user.setUsername(userDto.getUserName());
        user.setEmail(userDto.getEmail());
        user.setPassword(userDto.getPassword());
        return user;
    }

    public UserDto asUserDto(User user) {
        dto = new UserDto();
        dto.setUserName(user.getUsername());
        dto.setEmail(user.getEmail());
        return dto;
    }

    public List<UserDto> asListUserDto(List<User> users) {
        List<UserDto> dtos = new ArrayList<>();
        for (User user : users) {
            dtos.add(asUserDto(user));
        }
        return dtos;
    }

    public List<User> asListUser(List<UserDto> dtos) {
        List<User> users = new ArrayList<>();
        for (UserDto dto: dtos) {
            users.add(asUser(dto));
        }
        return users;
    }
}
