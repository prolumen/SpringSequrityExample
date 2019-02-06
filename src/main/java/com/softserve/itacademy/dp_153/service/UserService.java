package com.softserve.itacademy.dp_153.service;

import com.softserve.itacademy.dp_153.dao.UserDao;
import com.softserve.itacademy.dp_153.model.User;
import com.softserve.itacademy.dp_153.util.converters.UserConverter;
import com.softserve.itacademy.dp_153.util.dto.UserDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {
    @Autowired
    private UserDao userDao;
    private UserConverter converter = new UserConverter();

    public String createUser(UserDto dto) {
        if (findByEmail(dto.getEmail()) == null) {
            userDao.save(converter.asUser(dto));
            return "created";
        } else {
            return "user is exist";
        }
    }

    public User findByEmail(String email) {
       return userDao.findByEmail(email);
    }

    public List<User> getAllUsers() {
        return (List<User>) userDao.findAll();
    }
}
