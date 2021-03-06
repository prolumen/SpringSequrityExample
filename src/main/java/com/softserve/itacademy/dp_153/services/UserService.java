package com.softserve.itacademy.dp_153.services;

import com.softserve.itacademy.dp_153.dao.TokensDao;
import com.softserve.itacademy.dp_153.dao.UserDao;
import com.softserve.itacademy.dp_153.models.authentification.Role;
import com.softserve.itacademy.dp_153.models.authentification.State;
import com.softserve.itacademy.dp_153.models.authentification.Token;
import com.softserve.itacademy.dp_153.models.user.User;
import com.softserve.itacademy.dp_153.util.converters.UserConverter;
import com.softserve.itacademy.dp_153.util.dto.UserDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.validation.constraints.NotNull;
import java.util.List;
import java.util.Optional;

@Service
public class UserService {
    @Autowired
    private UserDao userDao;
    @Autowired
    private TokensDao tokensDao;
    @Autowired
    private UserConverter converter;
    @Autowired
    private TokenHandler tokenHandler;

    public String createUser(UserDto dto) {
        if (findByEmail(dto.getEmail()) == null) {
            User user = converter.asUser(dto);
            user.setRole(Role.ADMIN);
            user.setState(State.ACTIVE);
            userDao.save(user);
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

    public Optional<User> findById(@NotNull Integer id) {
        return userDao.findById(id);
    }

    public User findByUsername(@NotNull String value) {
        Optional<Token> token = tokensDao.findOneByValue(value);

        if (value != null) {
            return (User) userDao.findById(tokenHandler.extractUserId(value).get()).get();
        }
        return null;
    }
}
