package com.softserve.itacademy.dp_153.dao;

import com.softserve.itacademy.dp_153.models.authentification.Token;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface TokensDao extends CrudRepository<Token, Integer> {
    Optional<Token> findOneByValue(String value);
}
