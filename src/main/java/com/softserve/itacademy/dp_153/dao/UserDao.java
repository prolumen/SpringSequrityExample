package com.softserve.itacademy.dp_153.dao;

import com.softserve.itacademy.dp_153.model.User;
import org.springframework.data.repository.CrudRepository;

public interface UserDao extends CrudRepository<User, Integer> {
    User findByEmail(String email);
}
