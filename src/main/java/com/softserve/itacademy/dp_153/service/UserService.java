package com.softserve.itacademy.dp_153.service;

import com.softserve.itacademy.dp_153.dao.UserDao;
import com.softserve.itacademy.dp_153.model.User;
import com.softserve.itacademy.dp_153.util.converters.UserConverter;
import com.softserve.itacademy.dp_153.util.dto.UserDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import javax.validation.constraints.NotNull;
import java.util.List;
import java.util.Optional;

@Service
public class UserService implements UserDetailsService {
    @Autowired
    private UserDao userDao;
    @Autowired
    private UserConverter converter;

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

    public Optional<User> findById(@NotNull Integer id) {
        return userDao.findById(id);
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return (UserDetails) userDao.findByUsername(username);
    }

    private String getUsserExseptionMessage(String username){
        return null;
    }
}
