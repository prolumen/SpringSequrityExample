package com.softserve.itacademy.dp_153.dao;

import com.softserve.itacademy.dp_153.models.user.User;
import org.springframework.data.repository.CrudRepository;

public interface UserDao extends CrudRepository<User, Integer> {
    User findByEmail(String email);

    User findByUsername(String username);
}
