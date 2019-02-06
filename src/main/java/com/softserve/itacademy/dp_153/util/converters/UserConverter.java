package com.softserve.itacademy.dp_153.util.converters;

import com.softserve.itacademy.dp_153.model.User;
import com.softserve.itacademy.dp_153.util.dto.UserDto;

import java.util.ArrayList;
import java.util.List;

public class UserConverter {
//    @Autowired
//    UserDto dto;
//    @Autowired
//    User user;

    public User asUser(UserDto userDto) {
        User user = new User();
        user.setName(userDto.getUserName());
        user.setEmail(userDto.getEmail());
        user.setPassword(userDto.getPassword());
        return user;
    }

    public UserDto asUserDto(User user) {
        UserDto dto = new UserDto();
        dto.setUserName(user.getName());
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
//        dtos.iterator().forEachRemaining(UserDto -> users.add(asUser(UserDto)));
        for (UserDto dto: dtos) {
            users.add(asUser(dto));
        }
        return users;
    }
}
