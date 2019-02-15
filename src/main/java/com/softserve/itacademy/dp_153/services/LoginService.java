package com.softserve.itacademy.dp_153.services;

import com.softserve.itacademy.dp_153.dao.TokensDao;
import com.softserve.itacademy.dp_153.dao.UserDao;
import com.softserve.itacademy.dp_153.models.authentification.Token;
import com.softserve.itacademy.dp_153.models.user.User;
import com.softserve.itacademy.dp_153.util.dto.TokenDto;
import com.softserve.itacademy.dp_153.util.dto.UserDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Optional;

@Service
public class LoginService {
    @Autowired
    private TokensDao tokensDao;
    @Autowired
    private TokenHandler tokenHandler;

    @Autowired
    private PasswordEncoder encoder;
    @Autowired
    private UserDao userDao;
    private static final String NOT_FOUND_MESS = "User not found";
    private static final String INVALID_PASS_MESS = "Invalid password";

    public TokenDto login(UserDto dto) {
        Optional<User> userCandidate = Optional.ofNullable(userDao.findByUsername(dto.getUsername()));

        if (userCandidate.isPresent()) {
            User user = userCandidate.get();

            if (encoder.matches(dto.getPassword(), user.getPassword())) {
                Token token = new Token(user, tokenHandler.generateAccessToken(user.getId(), LocalDateTime.now()));

                tokensDao.save(token);
                return TokenDto.from(token);
            }
            return new TokenDto(INVALID_PASS_MESS);
        }

        return new TokenDto(NOT_FOUND_MESS);
    }
}
